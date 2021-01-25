package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.util.RandomUtils;

class RandomUtilsTest {

    @Test
    void nextInt() {
        assertThat(RandomUtils.nextInt(1,2)).isNotNegative();
    }
}