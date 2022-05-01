package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("RacingCars 객체를 만든다.")
    void create_racing_cars() {
        RacingCars rc = RacingCars.create(3);
        assertThat(rc.getValue().size()).isEqualTo(3);
    }
}
