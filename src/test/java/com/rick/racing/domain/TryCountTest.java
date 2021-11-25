package com.rick.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -10})
    @DisplayName("사용할 수 없는 시도 수")
    public void invalidTryCount(final int tryCount) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> TryCount.create(tryCount));
    }

    @Test
    @DisplayName("decrease 테스트")
    public void decrease() {
        final int value = 10;

        TryCount tryCount = TryCount.create(value);
        tryCount.decrease();

        assertThat(tryCount)
            .isEqualTo(TryCount.create(value - 1));
    }
}
