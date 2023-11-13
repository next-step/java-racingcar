package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("addCar_input carCount_size carCount")
    void addCar() {
        Cars cars = Cars.of(3);
        assertThat(cars.carList()).hasSize(3);
    }
}