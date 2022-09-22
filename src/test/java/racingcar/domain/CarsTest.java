package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void race() {
        Cars cars = new Cars(3);

        cars.race(0);

        assertThat(cars.getPositions()).isEqualTo(List.of(1, 1, 1));
    }
}
