package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    public void moveForward() {
        Car car = new Car();
        assertThat(car.moveForward()).isEqualTo(1);
    }

    @Test
    public void moveForwardTwice() {
        Car car = new Car();

        car.moveForward();

        assertThat(car.moveForward()).isEqualTo(2);
    }

    @Test
    public void position에_따른_shape_return() {
        Car car = new Car();

        car.moveForward();
        car.moveForward();
        car.moveForward();

        assertThat(car.makePositionShape()).isEqualTo("---");
    }
}