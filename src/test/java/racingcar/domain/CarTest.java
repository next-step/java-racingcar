package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차가 이동거리만큼 이동한다")
    @Test
    void move() {
        Car car = Car.of(1, "car1");

        assertThat(car.move(() -> 5)).isEqualTo(Car.of(6, "car1"));
    }
}