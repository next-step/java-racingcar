package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingCar.racingCar;

public class RacingTest {


    @Test
    @DisplayName("자동차 대수 0")
    void null_value() {
        assertThat(racingCar(0)).isEqualTo("");
    }
}
