package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void assertCar() {
        Car car = new Car();
        int TEST_NUMBER_LESS_THAN_FOUR = 3;
        int TEST_NUMBER_GREATER_THAN_FOUR = 5;

        car.moveCar();

        assertThat(car.getDistance()).isEqualTo(1);

        car.validateForMove(TEST_NUMBER_LESS_THAN_FOUR);
        assertThat(car.getDistance()).isEqualTo(1);

        car.validateForMove(TEST_NUMBER_GREATER_THAN_FOUR);
        assertThat(car.getDistance()).isEqualTo(2);
    }
}