package racingcar.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {

    @Test
    @DisplayName("랜덤 값 범위 테스트")
    void getNextInt() {
        assertThat(RandomUtils.getNextInt()).isBetween(0, 10);
    }
}