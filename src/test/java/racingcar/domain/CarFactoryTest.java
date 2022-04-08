package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void createCars() {
        int size = 5;

        List<Car> cars = CarFactory.generateCarsOfSize(size);

        assertThat(cars).hasSize(size);
    }
}