package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @DisplayName("빈 문자열 또는 null 입력 시 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNullStringReturnsZero(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isZero();
    }

    @DisplayName("숫자 문자열만 입력 시 해당 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10"})
    void singleNumberStringReturnsItself(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("쉼표 구분자 합 계산")
    @ParameterizedTest
    @CsvSource(value = {"'1,2'|3", "'0,1'|1", "'1,2,3'|6", "'1,10'|11"}, delimiter = '|')
    void sumWithDefaultDelimiter(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("쉼표, 콜론 구분자 합 계산")
    @ParameterizedTest
    @CsvSource(value = {"'1,2:3'|6", "'0:1'|1", "'1:2:3'|6", "'1:10'|11"}, delimiter = '|')
    void sumWithDefaultDelimiters(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 합 계산")
    @ParameterizedTest
    @CsvSource(value = {"'//;\n1;2;3'|6", "'//;\n0;1'|1", "'//;\n10;20'|30", "'//.\n1.2.3'|6", "'//|\n0|1'|1",
            "'//?\n10?20'|30"}, delimiter = '|')
    void sumWithCustomDelimiter(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자와 기본 구분자(쉼표, 콜론) 합 계산")
    @ParameterizedTest
    @CsvSource(value = {"'//;\n1;2:3'|6", "'//|\n1|2,3'|6"}, delimiter = '|')
    void sumWithDefaultAndCustomDelimiters(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 아닌 값 입력 시 RuntimeException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1,b", "10:@", " ", "//;\na;1", "//|\n1|b", "// \n1 b"})
    void nonNumericThrows(String input) {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("음수 입력 시 RuntimeException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "1,-1", "//;\n-1;2;3", "//|\n1|-2|3"})
    void negativeNumberThrows(String input) {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}