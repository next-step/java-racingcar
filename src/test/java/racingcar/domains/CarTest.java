package racingcar.domains;

import org.junit.jupiter.api.Test;
import racingcar.strategies.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 전진() {
        Car car = new Car("blue");

        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return true;
            }
        };

        car.move(moveStrategy);

        assertThat(car).isEqualTo(new Car("blue", 1));
    }

    @Test
    void 멈춤() {
        Car car = new Car("blue");

        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        };

        car.move(moveStrategy);

        assertThat(car).isEqualTo(new Car("blue", 0));
    }
}