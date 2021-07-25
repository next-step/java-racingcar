package step4;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
    private final List<String> carNames = Stream.of("pobi", "crong", "honux").collect(Collectors.toList());

    @Test
    void createCars() {
        List<Car> cars = new CarFactory().createCarsByName(carNames);

        assertThat(cars).hasSize(3);

        cars.forEach(car -> assertThat(car).isInstanceOf(Car.class));
    }
}
