package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomUtilsTest {

    @Test
    void nextInt() {
        assertThat(RandomUtils.nextInt(1,2)).isNotNegative();
    }
}