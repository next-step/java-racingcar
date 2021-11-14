package study.racing.utils;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomUtilsTest {

    private static final int TEST_COUNT = 1000;

    @DisplayName("랜덤 생성된 숫자가 인자로 전달된 범위 안에있는지 검증")
    @ParameterizedTest
    @ValueSource(ints = { 5, 10 })
    void nextIntTest(int limitRange) {
        for (int i = 0; i < TEST_COUNT; i++) {
            int result = RandomUtils.nextInt(limitRange);
            assertThat(result).isBetween(0, limitRange);
        }
    }

    @DisplayName("랜덤 숫자를 생성할 때 음수가 limit으로 주어지면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = { -100, -1, 0 })
    void nextIntInvalidLimitTest(int limitRange) {
        assertThatThrownBy(() -> RandomUtils.nextInt(limitRange)).isInstanceOf(RuntimeException.class);
    }
}
