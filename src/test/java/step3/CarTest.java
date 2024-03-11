package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.car.Car;
import step3.car.move.MoveStrategy;
import step3.car.move.RandomMoveStrategy;


class CarTest {


    @DisplayName("자동차는 외부의 조건에 따라 움직일 수 있다.")
    @Test
    void move() {
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public int move() {
                return 1;
            }

            @Override
            public boolean canMove() {
                return true;
            }
        };

        Car car = new Car(moveStrategy);
        car.move();

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}
