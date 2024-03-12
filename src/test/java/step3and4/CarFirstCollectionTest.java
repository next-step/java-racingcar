package step3and4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3and4.car.Car;
import step3and4.car.CarFirstCollection;
import step3and4.car.move.MoveStrategy;

import java.util.List;

class CarFirstCollectionTest {
    MoveStrategy moveStrategy;
    MoveStrategy onlyStopStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new MoveStrategy() {
            @Override
            public int move() {
                return 1;
            }

            @Override
            public boolean canMove() {
                return true;
            }
        };

        onlyStopStrategy = new MoveStrategy() {
            @Override
            public int move() {
                return 0;
            }

            @Override
            public boolean canMove() {
                return false;
            }
        };

    }

    @DisplayName("자동차들은 이동 전략에 맞게 이동할 수 있다.")
    @Test
    void moveCars() {

        List<Car> cars = List.of(new Car("pobi", moveStrategy), new Car("temp", moveStrategy), new Car("stop", moveStrategy), new Car("go!", moveStrategy));
        CarFirstCollection carFirstCollection = CarFirstCollection.from(cars);
        carFirstCollection.moveCars();

        List<Car> listCars = carFirstCollection.getCars();
        listCars.forEach(item -> Assertions.assertThat(item.getPosition()).isEqualTo(1));
    }

    @DisplayName("자동차 이동 결과를 반환한다.")
    @Test
    void createMoveResult() {
        List<Car> cars = List.of(new Car("pobi", moveStrategy), new Car("temp", moveStrategy), new Car("stop", moveStrategy), new Car("go!", moveStrategy));
        CarFirstCollection carFirstCollection = CarFirstCollection.from(cars);
        carFirstCollection.moveCars();

        int[] moveResult = carFirstCollection.createMoveResult();
        Assertions.assertThat(moveResult).containsExactly(1, 1, 1, 1);
    }

    @DisplayName("자동차 이름들을 반환한다. ")
    @Test
    void getNames() {
        List<Car> cars = List.of(new Car("pobi", moveStrategy), new Car("temp", moveStrategy), new Car("stop", moveStrategy), new Car("go!", moveStrategy));
        CarFirstCollection carFirstCollection = CarFirstCollection.from(cars);
        String[] carNames = carFirstCollection.getCarNames();
        Assertions.assertThat(carNames).containsExactly("pobi","temp", "stop","go!");
    }

    @DisplayName("자동차 경주 우승자를 반환한다.")
    @Test
    void getWins() {
        List<Car> cars = List.of(new Car("pobi", moveStrategy), new Car("temp", onlyStopStrategy), new Car("stop", onlyStopStrategy), new Car("go!", onlyStopStrategy));
        CarFirstCollection carFirstCollection = CarFirstCollection.from(cars);
        carFirstCollection.moveCars();
        String[] winCars = carFirstCollection.getWinCars();
        Assertions.assertThat(winCars).containsExactly("pobi");
    }
}
