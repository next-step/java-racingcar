package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource({"1 + 2,3", "1 - 2,-1", "3 * 4,12", "12 / 2,6"})
    @DisplayName("연산자 1개 case 테스트")
    void one_operation_calculator_test(String input, Integer expected) {
        Integer output = Calculator.equality(input);
        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1 + 2 + 3, 6", "1 - 2 + 1,0", "3 * 4 / 2,6", "12 / 2 - 4,2", "1 + 2 + 3 / 3, 2"})
    @DisplayName("연산자 2개 이상 case 테스트")
    void two_more_operation_calculator_test(String input, Integer expected) {
        Integer output = Calculator.equality(input);
        assertThat(output).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력이 Null 혹인 빈 문자열인 경우")
    void null_or_empty_input() {
        assertThatThrownBy(() -> {
            Calculator.equality(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Calculator.equality("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌경우")
    @ParameterizedTest
    @ValueSource(strings = {"1 ? 2", "3 ^ 5", "3 * 4 x 2",})
    void no_supported_operations(String input) {
        assertThatThrownBy(() -> {
            Calculator.equality(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연산 순서가 틀린 경우와 공백문자가 중간에 없는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1 2 *", "1+ 2", "1 + 2 3 /"})
    void no_exact_order(String input) {
        assertThatThrownBy(() -> {
            Calculator.equality(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
