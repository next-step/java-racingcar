package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void findWinners() {
        // test fixture
        Car pobi = new Car("pobi", 9);
        Car brown = new Car("brown", 3);
        Car jason = new Car("jason", 9);
        Cars cars = new Cars(Arrays.asList(
                pobi, brown, jason
        ));
        assertThat(cars.findWinners()).containsExactly(pobi, jason);
    }
}
