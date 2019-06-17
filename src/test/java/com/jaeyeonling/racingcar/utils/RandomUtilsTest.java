package com.jaeyeonling.racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RandomUtilsTest {

    private static final int RANDOM_VERIFY_REPEAT_COUNT = 10_000;

    @DisplayName("getIntWithBound 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 1, 100, 500, 234, 3453 })
    void getIntWithBound(final int bound) {
        for (int i = 0; i < RANDOM_VERIFY_REPEAT_COUNT; i++) {
            final int randomValue = RandomUtils.getIntWithBound(bound);
            assertThat(randomValue).isLessThan(bound);
        }
    }

    @DisplayName("getIntWithBound bound 양수가 아닌 값 입력 시 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -324, -4352452 })
    void getIntWithBoundWithNegative(final int bound) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RandomUtils.getIntWithBound(bound));
    }
}
