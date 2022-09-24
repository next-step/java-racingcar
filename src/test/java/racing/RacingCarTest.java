package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    void getRandomNum() {

        assertThat(RacingCar.getRandomNum())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
