package racingCar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @Test
    void generateCars() {
        Cars cars = Cars.generateCars(3);
        assertThat(cars.getCarList()).hasSize(3);
    }
}
