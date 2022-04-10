package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @Test
    void 자동차_전진() {
        RacingCar racingCar = new RacingCar();
        racingCar.moveForward();
        assertThat(racingCar.isMoved()).isTrue();
        assertThat(racingCar.getPosition()).isGreaterThan(0);
    }

    @Test
    void 자동차_멈춤() {
        RacingCar racingCar = new RacingCar();
        racingCar.stop();
        assertThat(racingCar.isMoved()).isFalse();
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }
}