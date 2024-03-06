package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomUtilTest {

    @Test
    void randomNumberZeroToNine() {
        assertThat(RandomUtil.randomNumberZeroToNine())
                .isGreaterThanOrEqualTo(0)
                .isLessThan(10);
    }
}