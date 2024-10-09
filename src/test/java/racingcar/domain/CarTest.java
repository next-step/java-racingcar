package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차가 전진 조건일때 전진한다")
    @Test
    void carMovesForward() {

        Car car = new Car();
        car.move(() -> true);

        assertThat(car.getPosition())
                .isEqualTo(1);
    }

    @DisplayName("자동차가 정지 조건일때 멈춰있는다.")
    @Test
    void carMovesStop() {
        Car car = new Car();
        car.move(() -> false);

        assertThat(car.getPosition())
                .isEqualTo(0);
    }

}
