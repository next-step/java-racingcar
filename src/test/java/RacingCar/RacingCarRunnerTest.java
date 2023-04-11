package RacingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarRunnerTest {
    @Test
    void 랜덤_수_구하기() {
        int randomNum = RacingCarRunner.getRandomNumber();
        assertThat(randomNum).isGreaterThan(-1);
        assertThat(randomNum).isLessThan(10);
    }

    @Test
    void 자동차_이동_가능_여부_확인() {
        assertThat(RacingCarRunner.isRunnable(4)).isEqualTo(true);
        assertThat(RacingCarRunner.isRunnable(3)).isEqualTo(false);
    }
}
