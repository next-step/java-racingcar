package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.FixedMoving;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차가 멈추는 조건일 경우 position 값이 유지된다.")
    void carStop() {
        Car car = new Car("test", FixedMoving.alwaysStop, 0);
        car.move();

        assertThat(car.position()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("자동차가 전진 조건일 경우 position 값이 1 증가한다.")
    void carGo() {
        Car car = new Car("test", FixedMoving.alwaysGo, 0);
        car.move();

        assertThat(car.position()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("maxPosition 값과 자동차의 position 값이 같으면 Top 이다.")
    void isTop() {
        int maxPosition = 3;
        assertThat(new Car("paul", 3).isTop(maxPosition)).isTrue();
    }

    @Test
    @DisplayName("maxPosition 값과 자동차의 position 같지 않으면 Top 이 아니다.")
    void isNotTop() {
        int maxPosition = 3;
        assertThat(new Car("paul", 2).isTop(maxPosition)).isFalse();
    }
}
