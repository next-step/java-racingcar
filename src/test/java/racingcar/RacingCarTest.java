package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingCarTest {

    @Test
    void 랜덤값() {
        int actual = RacingCar.getRandom();
        assertAll(
                () -> assertThat(actual).isLessThanOrEqualTo(9),
                () -> assertThat(actual).isGreaterThanOrEqualTo(0)
        );
    }
}
