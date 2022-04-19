package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.FixedMoving;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차가 멈추는 조건일 경우 position 값이 유지된다.")
    void carStop() {
        Car car = new Car("test", FixedMoving.alwaysStop);
        int oldPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(oldPosition);
    }

    @Test
    @DisplayName("자동차가 전진 조건일 경우 position 값이 1 증가한다.")
    void carGo() {
        Car car = new Car("test", FixedMoving.alwaysGo);
        int oldPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(oldPosition + 1);
    }
}
