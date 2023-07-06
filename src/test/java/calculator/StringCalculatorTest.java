package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
        "1,2!3",
        "1,2,3!6",
        "1,2:3!6",
    }, delimiter = '!')
    @DisplayName("양수 값이 들어오면, 양수 값을 더한 값을 반환한다.")
    void returnPositiveNumSumResult(String value, int expected) {
        assertThat(StringCalculator.sum(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "a:1",
        "-1:1",
    })
    @DisplayName("양수이외의 값이 들어오면, IllegalArgumentException 을 던진다.")
    void throwIllegalArgumentExceptionWhenNotPositiveNum(String value) {
        assertThatThrownBy(() -> StringCalculator.sum(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Blank, Null 값이 들어오면, 0을 반환한다.")
    void returnZeroWhenBlankOrNull(String value) {
        assertThat(StringCalculator.sum(value)).isZero();
    }

    @Test
    @DisplayName("커스텀 구분자를 지정하면 커스텀 구분자에 맞춰 문자열 덧셈을 실행한 값을 반환한다.")
    void returnPositiveNumSumResultWhenCustomSeparator() {
        assertThat(StringCalculator.sum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("2글자 이상의 커스텀 구분자를 지정하면, 커스텀 구분자에 맞춰 문자열 덧셈을 실행한 값을 반환한다.")
    void returnPositiveNumSumResultWhenCustomSeparatorLengthTwo() {
        assertThat(StringCalculator.sum("//;;\n1;;2;;3")).isEqualTo(6);
    }
}
