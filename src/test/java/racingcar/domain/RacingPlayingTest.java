package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingPlayingTest {

    @Test
    void 모든차앞으로전진() {
        RacingPlaying racingPlaying = new RacingPlaying(new ArrayList<>(Arrays.asList("pobi", "yang", "woo")));
        List<RacingCar> racingCarList = racingPlaying.getRacingCarList();
        racingCarList.get(0).moveForward(5);
        racingCarList.get(1).moveForward(3);
        racingCarList.get(2).moveForward(6);

        assertThat(racingCarList.get(0).getPosition()).isEqualTo(1);
        assertThat(racingCarList.get(1).getPosition()).isZero();
        assertThat(racingCarList.get(2).getPosition()).isEqualTo(1);
    }
}
