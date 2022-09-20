package study.racing.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {


    @ParameterizedTest
    @CsvSource(value = {"null, 0", "'', 0", "' ', 0"}, nullValues = {"null"})
    @DisplayName("Null 혹은 Blank String은 계산 후 0을 반환한다.")
    void isCalculate_ShouldReturnZeroForBlankOrNull(String text, int expected) {
        assertThat(StringAddCalculator.calculate(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3/6", "1,2:3/6", "1:2,3/6"}, delimiter = '/')
    @DisplayName("콤마와 세미콜론으로 구분된 문자열은 구분된 숫자의 합을 반한한다.")
    void isCalculate_ShouldReturnSumForCommaAndColonDelimiter(String text, int expected) {
        assertThat(StringAddCalculator.calculate(text)).isEqualTo(expected);
    }

    @Test
    @DisplayName("사용자 정의 구분자로 구분된 문자열은 숫자의 합을 반환한다.")
    void isCalculate_ShouldReturnSumForCustomDelimiter() {
        int result = StringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"ㅂ,2,3/숫자 이외의 값", "q,2,3/숫자 이외의 값", "-11,2,3/음의 정수"}, delimiter = '/')
    @DisplayName("숫자 이외의 값이나 음수를 입력하면 RuntimeException을 던진다.")
    void isCalculate_ShouldThrowRuntimeExceptionForNegativeIntegerOrNotANumber(String text, String expectedMessage) {
        assertThatThrownBy(() -> {
            StringAddCalculator.calculate(text);
        }).hasMessageContaining(expectedMessage);
    }
}
