package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {
    @Test
    void 임의의_양수_생성은_0과_최댓값_사이_숫자를_반환한다() {
        assertThat(RandomUtils.getRandomPositiveInt(1)).isBetween(0, 1);
    }
}
