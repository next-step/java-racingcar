package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void generateCars() {
        Cars cars = Cars.generateCars(3);
        assertThat(cars.getCarList()).hasSize(3);
    }
}
