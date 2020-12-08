package carrace.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void makeCarListTest() {
        List<Car> cars = CarFactory.makeCars(5);

        assertThat(cars.size()).isEqualTo(5);
        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

}