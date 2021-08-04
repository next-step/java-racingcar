package racingCar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Car pobi, crong, honux;
    List<Car> original;

    @BeforeEach
    void setUp() {
        pobi = new Car("pobi", 2);
        crong = new Car("crong", 2);
        honux = new Car("honux", 1);
        original = Arrays.asList(pobi, crong, honux);
    }

    @Test
    void move() {
        Cars cars = new Cars(original);
        assertThat(cars.move(() -> true)).isEqualTo(original);
    }

    @Test
    void findWinners() {
        original = Arrays.asList(pobi, crong, honux);
        Cars cars = new Cars(original);
        assertThat(cars.findWinners())
                .containsExactly(pobi, crong);
        assertThat(Cars.findWinners(original, new Position(2)))
                .containsExactly(pobi, crong);
    }
}