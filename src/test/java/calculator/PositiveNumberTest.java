package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import calculator.exception.InvalidNumberFormatException;
import calculator.exception.NotPositiveNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @DisplayName("입력 문자열을 숫자로 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void stringToInt(String text) {
        assertThat(new PositiveNumber(text)).isEqualTo(new PositiveNumber(1));
    }

    @DisplayName("숫자 이외의 문자열을 전달하는 경우 InvalidNumberFormatException 예외를 반환한다.")
    @Test
    void notNumber() {
        assertThatExceptionOfType(InvalidNumberFormatException.class)
            .isThrownBy(() -> new PositiveNumber("not number"));
    }

    @DisplayName("음수 문자열을 전달하는 경우 NotPositiveNumberException 예외를 반환한다.")
    @Test
    void negativeNumber() {
        assertThatExceptionOfType(NotPositiveNumberException.class)
            .isThrownBy(() -> new PositiveNumber("-3"));
    }
}
