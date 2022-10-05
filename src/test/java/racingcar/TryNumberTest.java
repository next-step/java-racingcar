package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumberTest {

    @Test
    @DisplayName("양수값 테스트")
    void positiveNumber() {
        TryNumber positive = new TryNumber(5);
        Assertions.assertThat(positive.getNumber()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("음수값 예외")
    void NotPositiveException() {
        Assertions.assertThatThrownBy(() -> new TryNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도횟수는 0이상만 가능합니다.");
    }
}