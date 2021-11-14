package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingPlayDataTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("잘못된 차 대수 입력 테스트")
    void invalidCarCount(int value) {
        final int validTryCount = 10;
        assertThatIllegalArgumentException().isThrownBy(()->new RacingPlayData(value, validTryCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("잘못된 시도 횟수 입력 테스트")
    void invalidCTryCount(int value) {
        final int validCarCount = 3;
        assertThatIllegalArgumentException().isThrownBy(()->new RacingPlayData(validCarCount, value));
    }
}
