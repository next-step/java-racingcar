package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveTest {

    @Test
    @DisplayName("양수값 테스트")
    void positiveNumber() {
        Positive positive = new Positive(5);
        Assertions.assertThat(positive.getNumber()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("음수값 예외")
    void NotPositiveException() {
        Assertions.assertThatThrownBy(() -> new Positive(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}