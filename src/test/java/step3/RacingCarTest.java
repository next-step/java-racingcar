package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static step3.RacingCar.makeRacingCar;

import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    public void 자동차_생성() {
        int[] result = makeRacingCar(3);
        assertThat(result).hasSize(3);
    }
}