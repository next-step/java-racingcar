package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.strategy.MovingStrategy;
import step3.strategy.RandomNumMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차가 전진한다.")
    void move() {
        Car car = new Car();
        MovingStrategy movingStrategy = new RandomNumMovingStrategy() {
            @Override
            public boolean canForward() {
                return true;
            }
        };

        car.move(movingStrategy);

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 정지한다.")
    void canNotMove() {
        Car car = new Car();
        MovingStrategy movingStrategy = new RandomNumMovingStrategy() {
            @Override
            public boolean canForward() {
                return false;
            }
        };

        car.move(movingStrategy);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
