package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorHelperTest {

    @DisplayName("덧셈 검증")
    @ParameterizedTest(name = "{index}번째 => {0} {1} {2} 연산결과 : {3}")
    @CsvSource(value = {
            "3 | + | 2 | 5",
            "5 | + | 4 | 9",
            "21 | + | 31 | 52"
    }, delimiter = '|')
    void plus(Long operand1, String formula, Long operand2, Long expected) {
        assertThat(CalculatorHelper.calculate(formula, operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("뺄셈 검증")
    @ParameterizedTest(name = "{index}번째 => {0} {1} {2} 연산결과 : {3}")
    @CsvSource(value = {
            "4 | - | 5 | -1",
            "5 | - | 1 | 4",
            "21 | - | 4 | 17"
    }, delimiter = '|')
    void minus(Long operand1, String formula, Long operand2, Long expected) {
        assertThat(CalculatorHelper.calculate(formula, operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("곱셈 검증")
    @ParameterizedTest(name = "{index}번째 => {0} {1} {2} 연산결과 : {3}")
    @CsvSource(value = {
            "7 | * | 5 | 35",
            "5 | * | 1 | 5",
            "21 | * | 4 | 84"
    }, delimiter = '|')
    void multiply(Long operand1, String formula, Long operand2, Long expected) {
        assertThat(CalculatorHelper.calculate(formula, operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("나눗셈 검증")
    @ParameterizedTest(name = "{index}번째 => {0} {1} {2} 연산결과 : {3}")
    @CsvSource(value = {
            "7 | / | 5 | 1",
            "5 | / | 1 | 5",
            "21 | / | 4 | 5"
    }, delimiter = '|')
    void division(Long operand1, String formula, Long operand2, Long expected) {
        assertThat(CalculatorHelper.calculate(formula, operand1, operand2)).isEqualTo(expected);
    }
}