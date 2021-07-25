package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.createWithDefaults(3);
    }

    @Test
    void move() {
        List<Car> carList = Arrays.asList(
                new Car(1),
                new Car(1),
                new Car(1));
        Cars expected = Cars.createFromList(carList);
        assertThat(cars.move(() -> true)).isEqualTo(expected);
    }

    @Test
    void stop() {
        Cars expected = Cars.createWithDefaults(3);
        assertThat(cars.move(() -> false)).isEqualTo(expected);
    }
}
