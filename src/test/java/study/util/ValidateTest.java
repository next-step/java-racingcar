package study.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static study.util.Validate.*;

class ValidateTest {

    @DisplayName("양수는 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 100})
    void positiveNumber(int number) {
        assertThatCode(() -> validatePositive(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("0은 예외가 발생하지 않는다")
    @Test
    void zero() {
        assertThatCode(() -> validatePositive(0))
                .doesNotThrowAnyException();
    }

    @DisplayName("음수는 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    void negativeNumber(int number) {
        assertThatThrownBy(() -> validatePositive(number))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("null 또는 빈 문자열은 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(String input) {
        assertThatThrownBy(() -> validateNullOrEmpty(input))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("유효한 문자열은 예외가 발생하지 않는다")
    @Test
    void validString() {
        assertThatCode(() -> validateNullOrEmpty("1,2,3"))
                .doesNotThrowAnyException();
    }
}