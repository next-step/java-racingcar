package step3and4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3and4.car.Car;
import step3and4.car.CarEntry;
import step3and4.car.move.MoveStrategy;

import java.util.List;

class CarEntryTest {
    MoveStrategy moveStrategy;
    MoveStrategy onlyStopStrategy;
    MoveStrategy winMoveStrategy;

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

        winMoveStrategy = new MoveStrategy() {
            @Override
            public int move() {
                return 3;
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
        CarEntry carEntry = CarEntry.from(cars);
        carEntry.moveCars();

        List<Car> listCars = carEntry.getCars();
        listCars.forEach(item -> Assertions.assertThat(item.getPosition()).isEqualTo(1));
    }

    @DisplayName("자동차 이동 결과를 반환한다.")
    @Test
    void createMoveResult() {
        List<Car> cars = List.of(new Car("pobi", moveStrategy), new Car("temp", moveStrategy), new Car("stop", moveStrategy), new Car("go!", moveStrategy));
        CarEntry carEntry = CarEntry.from(cars);
        carEntry.moveCars();

        int[] moveResult = carEntry.createMoveResult();
        Assertions.assertThat(moveResult).containsExactly(1, 1, 1, 1);
    }

    @DisplayName("자동차 이름들을 반환한다. ")
    @Test
    void getNames() {
        List<Car> cars = List.of(new Car("pobi", moveStrategy), new Car("temp", moveStrategy), new Car("stop", moveStrategy), new Car("go!", moveStrategy));
        CarEntry carEntry = CarEntry.from(cars);
        List<String> carNames = carEntry.getCarNames();
        Assertions.assertThat(carNames).containsExactly("pobi", "temp", "stop", "go!");
    }

    @DisplayName("자동차 경주 우승자를 반환한다.")
    @Test
    void getWins() {
        List<Car> cars = List.of(new Car("aaa", winMoveStrategy), new Car("bbb", winMoveStrategy), new Car("ccc", winMoveStrategy), new Car("temp", moveStrategy), new Car("stop", onlyStopStrategy), new Car("go!", onlyStopStrategy));
        CarEntry carEntry = CarEntry.from(cars);
        carEntry.moveCars();
        String[] winCars = carEntry.getWinCars();
        Assertions.assertThat(winCars).containsOnly("aaa","bbb","ccc");
    }
}
