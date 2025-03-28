package step4;

import org.junit.jupiter.api.Test;
import step4.domain.*;

import static org.assertj.core.api.Assertions.assertThat;


class CarFactoryTest {

    @Test
    void shouldCreateCar() {
        CarNames carNames = new CarNames("1,2");
        Cars cars = CarFactory.createCars(carNames);

        assertThat(cars.getCars()).containsExactly(
                new Car("1"),
                new Car("2")
        );
    }
}
