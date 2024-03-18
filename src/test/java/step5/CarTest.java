package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.car.Car;
import step5.domain.car.move.MoveStrategy;


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

        Car car = new Car("pobi",moveStrategy);
        car.move();

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}
