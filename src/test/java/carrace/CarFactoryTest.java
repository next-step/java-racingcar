package carrace;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarFactoryTest {

    static final int NUMBER_OF_CARS = 5;

    @Test
    void createCars_test() {
        assertThat(CarFactory.createCars(NUMBER_OF_CARS).size()).isEqualTo(NUMBER_OF_CARS);
    }
}