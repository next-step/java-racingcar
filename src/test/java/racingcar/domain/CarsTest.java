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
        cars = Cars.createWithNames(Arrays.asList("pobi", "crong", "honux"));
    }

    @Test
    void move() {
        List<Car> carList = Arrays.asList(
                Car.createWithNameAndPosition("pobi", 1),
                Car.createWithNameAndPosition("crong", 1),
                Car.createWithNameAndPosition("honux", 1));
        Cars expected = Cars.createFromList(carList);
        assertThat(cars.move(() -> true)).isEqualTo(expected);
    }

    @Test
    void stop() {
        List<Car> carList = Arrays.asList(
                Car.createWithNameAndPosition("pobi", 0),
                Car.createWithNameAndPosition("crong", 0),
                Car.createWithNameAndPosition("honux", 0));
        Cars expected = Cars.createFromList(carList);
        assertThat(cars.move(() -> false)).isEqualTo(expected);
    }
}
