package pobiRacingCar.domain;

import org.junit.jupiter.api.Test;
import pobiRacingCar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
    @Test
    void yes_create() {
        List<Car> cars = CarFactory.create("pobi","crong");
        assertThat(cars).hasSize(2);
        assertThat(cars).containsExactly(new Car(), new Car());
    }
}
