package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 자동차_객체_생성() {
        RacingCar car1 = new RacingCar("car1");

        assertThat(car1.getCarName()).isEqualTo("car1");
        assertThat(car1.getPosition()).isEqualTo(0);
    }
}