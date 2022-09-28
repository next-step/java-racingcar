package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"-0", "1,2-3", "1,2,3-6"}, delimiter = '-')
    @DisplayName("쉼표(,)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void add_ShouldReturnSumDelimitByComma(String input, String expected) {
        assertThat(Calculator.sum(input)).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void add_ShouldReturnSumDelimitByColon() {
        assertThat(Calculator.sum("1:2:3")).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3-6", "//a\\n1a2a3-6"}, delimiter = '-')
    @DisplayName("커스텀 구분자를 포함한 문자열을 전달하는 경우 해당 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void add_ShouldReturnSumWithCustomizedDelimiter(String input, String expected) {
        assertThat(Calculator.sum(input)).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하는 경우 IllegalArgumentException 예외를 throw한다.")
    void add_ShouldThrowExceptionWhenNegativeNumberInput() {
        assertThatThrownBy(() -> Calculator.sum("ㄱ,1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("");
    }

    @Test
    @DisplayName("문자열 계산기에 음수를 전달하는 경우 IllegalArgumentException 예외를 throw한다.")
    void add_ShouldThrowExceptionWhenNonNumberInput() {
        assertThatThrownBy(() -> Calculator.sum("-1,-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("");
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n-1;2;3:6", "//a\\n1a-2a3:6"}, delimiter = ':')
    @DisplayName("커스텀 구분자를 포함한 문자열을 전달하는 경우 음수를 전달하는 경우 IllegalArgumentException 예외를 throw한다.")
    void add_ShouldThrowExceptionWhenNonNumberInputWithCustomizedDelimiter(String input, String output) {
        assertThatThrownBy(() -> Calculator.sum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("");
    }
}
