package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.car.Car;
import step3.car.CarList;
import step3.car.move.MoveStrategy;

import java.util.List;

class CarListTest {
    MoveStrategy moveStrategy;

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

    }

    @DisplayName("자동차들은 이동 전략에 맞게 이동할 수 있다.")
    @Test
    void moveCars() {

        List<Car> cars = List.of(new Car(moveStrategy), new Car(moveStrategy), new Car(moveStrategy), new Car(moveStrategy));
        CarList carList = CarList.from(cars);
        carList.moveCars();

        List<Car> listCars = carList.getCars();
        listCars.forEach(item -> Assertions.assertThat(item.getPosition()).isEqualTo(1));
    }

    @DisplayName("자동차 이동 결과를 반환한다.")
    @Test
    void createMoveResult() {
        List<Car> cars = List.of(new Car(moveStrategy), new Car(moveStrategy), new Car(moveStrategy), new Car(moveStrategy));
        CarList carList = CarList.from(cars);
        carList.moveCars();

        int[] moveResult = carList.createMoveResult();
        Assertions.assertThat(moveResult).containsExactly(1, 1, 1, 1);
    }
}
