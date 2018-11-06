package racingcar;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingCarAcceleratorTest {

    @Test
    public void 가속장치는_최대속도를_넘을수없다() {
        RacingCarAccelerator racingCarAccelerator = new RacingCarAccelerator(4);
        assertThat(racingCarAccelerator.speedUp()).isLessThanOrEqualTo(1);
    }
}