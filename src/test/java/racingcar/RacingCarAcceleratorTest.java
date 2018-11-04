package racingcar;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingCarAcceleratorTest {

    @Test
    public void 가속장치는_최대속도를_넘을수없다() {
        int maxSpeed = 5;
        RacingCarAccelerator racingCarAccelerator = new RacingCarAccelerator(maxSpeed);

        assertThat(racingCarAccelerator.stepOn(0)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(1)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(2)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(3)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(4)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(5)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(6)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(7)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(8)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(9)).isLessThanOrEqualTo(maxSpeed);
        assertThat(racingCarAccelerator.stepOn(10)).isLessThanOrEqualTo(maxSpeed);
    }
}