package racing;

import org.junit.jupiter.api.Test;
import racing.util.RandomUtil;

import static org.assertj.core.api.Assertions.*;

class RandomUtilTest {

    @Test
    void randomNumber() {
        int bound = 10;
        int randomNumber = RandomUtil.randomNumber(bound);

        assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(bound);

    }
}