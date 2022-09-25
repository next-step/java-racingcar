package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void moveForward() {
        Car car = new Car(0);
        Assertions.assertThat(car.moveForward()).isEqualTo(1);
    }

    @Test
    public void moveForwardTwice() {
        Car car = new Car(0);

        car.moveForward();

        Assertions.assertThat(car.moveForward()).isEqualTo(2);
    }
}