package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RandomUtilTest {

    @Test
    void randomNumber() {
        int bound = 10;
        int randomNumber = RandomUtil.randomNumber(bound);

        assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(bound);

    }
}