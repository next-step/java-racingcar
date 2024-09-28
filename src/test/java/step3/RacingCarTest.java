package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static step3.RacingCar.makeRacingCar;
import static step3.RacingCar.makeTryCount;

import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    public void 자동차_생성() {
        int[] result = makeRacingCar(3);
        assertThat(result).hasSize(3);
    }

    @Test
    public void 시도횟수_입력() {
        int result = makeTryCount(3);
        assertThat(result).isEqualTo(3);
    }
}