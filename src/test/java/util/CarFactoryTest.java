package util;

import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @Test
    public void createCarsTest() {
        String names = "a,b,c";
        List<Car> cars = CarFactory.createCars(names);
        assertThat(cars).hasSize(3);
        assertThat(cars).contains(new Car("a"), new Car("b"), new Car("c"));
    }

}
