package step3.racingCar;

import org.junit.jupiter.api.Test;
import step3.racingCar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void generateCars() {
        Cars cars = Cars.generateCars(3);
        assertThat(cars.getCarList()).hasSize(3);
    }
}
