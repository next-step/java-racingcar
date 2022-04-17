package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MovingStrategy;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    MovingStrategy alwaysGoMoving = new MovingStrategy() {
        @Override
        public boolean isMoving() {
            return true;
        }
    };

    MovingStrategy alwaysStopMoving = new MovingStrategy() {
        @Override
        public boolean isMoving() {
            return false;
        }
    };

    @Test
    @DisplayName("자동차가 멈추는 조건일 경우 position 값이 유지된다.")
    void carStop() {
        Car car = new Car("test", alwaysStopMoving);
        int oldPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(oldPosition);
    }

    @Test
    @DisplayName("자동차가 전진 조건일 경우 position 값이 1 증가한다.")
    void carGo() {
        Car car = new Car("test", alwaysGoMoving);
        int oldPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(oldPosition + 1);
    }
}
