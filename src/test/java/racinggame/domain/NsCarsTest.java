package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NsCarsTest {
    @Test
    void findWinners() {
        // test fixture
        Car pobi = new Car("pobi", 9);
        Car brown = new Car("brown", 3);
        Car jason = new Car("jason", 9);
        NsCars cars = new NsCars(Arrays.asList(
                pobi, brown, jason
        ));
        assertThat(cars.findWinners()).containsExactly(pobi, jason);
    }
}
