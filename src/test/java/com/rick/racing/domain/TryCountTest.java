package com.rick.racing.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    @DisplayName("사용할 수 없는 시도 수")
    public void invalidTryCount(final int tryCount) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> TryCount.create(tryCount));
    }
}
