package step3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
    @Test
    void createCars() {
        List<Car> cars = new CarFactory().createCars(5);

        assertThat(cars).hasSize(5);

        cars.forEach(car -> assertThat(car).isInstanceOf(Car.class));
    }
}
