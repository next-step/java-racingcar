package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @Test
    void 자동차_전진() {
        RacingCar racingCar = new RacingCar();
        racingCar.moveForward();
        assertThat(racingCar.getPosition()).isGreaterThan(0);
    }
}