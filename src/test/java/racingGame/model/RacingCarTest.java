package racingGame.model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Test
    public void 초기_위치체크() {
        RacingCar racingCar = new RacingCar();

        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    public void 한번_이동후_위치체크() {
        RacingCar racingCar = new RacingCar();
        racingCar.setForward();

        assertThat(racingCar.getPosition()).isEqualTo(1);
    }
}