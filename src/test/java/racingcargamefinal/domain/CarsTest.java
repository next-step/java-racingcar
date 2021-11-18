package racingcargamefinal.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarsTest {

    @Test
    void create() {
        String carNames = "pobi,crong,honux";

        assertDoesNotThrow(() -> {
            new Cars(carNames);
        });
    }

    @Test
    void findWinners() {
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 1);
        Car honux = new Car("honux", 3);

        Cars cars = new Cars(Arrays.asList(pobi, crong, honux));

        assertThat(cars.findWinners().getWinners()).containsExactly(pobi, honux);
    }

}
