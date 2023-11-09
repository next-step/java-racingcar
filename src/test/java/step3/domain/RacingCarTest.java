package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void moveTest() {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.getDistance()).isEqualTo(0);

        racingCar.move(4);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

}