package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    void isMoveOrStopCar () {
        Car car = new NextStepCar();
        assertThat(car.moveForward()).isEqualTo(1);
        assertThat(car.moveForward()).isEqualTo(2);
        assertThat(car.moveForward()).isEqualTo(3);
        assertThat(car.moveForward()).isEqualTo(4);
        assertThat(car.moveForward()).isEqualTo(5);
    }
}