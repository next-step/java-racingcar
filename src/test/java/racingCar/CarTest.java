package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void shouldMoveForwardIfConditionIsTrue() {
        Car car = new Car("Test Car");

        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    void shouldNotMoveForwardIfConditionIsFalse() {
        Car car = new Car("Test Car");

        car.move(() -> false);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
