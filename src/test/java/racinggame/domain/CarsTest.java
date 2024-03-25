package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 우승자_찾기() {
        Car pobi = new Car("pobi", 4);
        Car jason = new Car("jason", 3);
        Car woni = new Car("woni", 4);
        Cars cars = new Cars(Arrays.asList(pobi, jason, woni));
        assertThat(cars.findWinners()).hasSize(2);
        assertThat(cars.findWinners()).contains(pobi, woni);
    }
}
