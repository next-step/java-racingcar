package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void assertCar() {
        Car car = new Car();
        int testValueLessThanFour = 3;
        int testValueGreaterThanFour = 5;

        car.moveCar();

        assertThat(car.getDistance()).isEqualTo(1);

        car.validateForMove(testValueLessThanFour);
        assertThat(car.getDistance()).isEqualTo(1);

        car.validateForMove(testValueGreaterThanFour);
        assertThat(car.getDistance()).isEqualTo(2);
    }
}