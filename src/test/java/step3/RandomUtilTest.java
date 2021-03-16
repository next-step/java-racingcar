package step3;

import org.junit.jupiter.api.Test;
import step3.utils.RandomGenerator;
import step3.utils.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RandomUtilTest {
    @Test
    void getRandom() {
        // given
        RandomGenerator randomGenerator = new RandomUtil();

        // when
        int actual = randomGenerator.getRandom();

        // then
        assertAll(
                () -> assertThat(actual).isGreaterThanOrEqualTo(0),
                () -> assertThat(actual).isLessThanOrEqualTo(9)
        );

    }
}
