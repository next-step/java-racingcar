package racing.controller;

import org.junit.jupiter.api.Test;
import racing.domain.Cars;
import racing.domain.Moving;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    @Test
    void 단일선수_우승자() {
        Cars cars = new Cars(new String[]{"Car1"});
        cars.moveCar(new Moving());
        assertThat(Racing.winners(cars)).isEqualTo("Car1");
    }
}