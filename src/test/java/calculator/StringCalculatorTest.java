package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @DisplayName("빈 문자열 또는 null 입력 시 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNullStringReturnsZero(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력 시 해당 숫자를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10"})
    void singleNumberStringReturnsSameNumber(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자 문자열과 쉼표 구분자로 이루어진 문자열 입력 시 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"'1,2'|3", "'0,1'|1", "'1,2,3'|6", "'1,10'|11"}, delimiter = '|')
    void defaultDelimiterStringReturnsSum(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 문자열과 쉼표, 콜론 구분자로 이루어진 문자열 입력 시 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"'1,2:3'|6", "'0:1'|1", "'1:2:3'|6", "'1:10'|11"}, delimiter = '|')
    void defaultDelimitersStringReturnsSum(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 문자열과 커스텀 구분자로 이루어진 문자열 입력 시 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"'//;\n1;2;3'|6", "'//;\n0;1'|1", "'//;\n10;20'|30"}, delimiter = '|')
    void customDelimiterStringReturnsSum(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 문자열과 특수문자인 커스텀 구분자로 이루어진 문자열 입력 시 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"'//.\n1.2.3'|6", "'//|\n0|1'|1", "'//?\n10?20'|30"}, delimiter = '|')
    void customDelimiterSpecialCharStringReturnsSum(String input, int expected) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(expected);
    }

}