package racingcar.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {
    private final int MIN = 0;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void 임의의_양수_생성은_0과_최댓값_사이_숫자를_반환한다(int max) {
        assertThat(RandomUtils.getRandomPositiveInt(max)).isBetween(MIN, max);
    }
}
