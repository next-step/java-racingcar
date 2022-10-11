package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void race() {
        Cars cars = Cars.namesOf(List.of("a", "b", "c"));

        cars.race(0);

        assertThat(cars.getCars()).isEqualTo(List.of(1, 1, 1));
    }
}
