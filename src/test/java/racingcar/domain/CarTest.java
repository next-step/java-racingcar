package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("position 값을 1 증가시킨다.")
    void moveForward_ShouldPlus1PositionValue() {
        Car car = Car.nameOf("Test");

        car.moveForward();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
