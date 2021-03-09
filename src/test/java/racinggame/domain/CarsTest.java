package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void create_names() {
        Cars cars = new Cars("pobi,jason,cu");
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void findWinners() {
        Cars cars = new Cars(Arrays.asList(
                new Car("pobi", 3),
                new Car("jason", 2),
                new Car("cu", 3)));

        Winners winners = new Winners(Arrays.asList(
                new Car("pobi", 3),
                new Car("cu", 3)
        ));
        assertThat(cars.findWinners()).isEqualTo(winners);
    }
}
