package calculator.operation;

import calculator.value.CalculatorValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "+|     4|      2|      6",
            "+|    -4|      2|     -2",
            "+|     0|      3|      3"
    }, delimiter = '|')
    @DisplayName("덧셈 연산 검증")
    void plus(String operator, Long operand1, Long operand2, Long expected) {
        Long result = Operator.calculate(getTestCalculatorValue(operator, operand1, operand2));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-|     4|      2|      2",
            "-|    -4|     -2|     -2",
            "-|     0|      3|     -3"
    }, delimiter = '|')
    @DisplayName("뺄셈 연산 검증")
    void minus(String operator, Long operand1, Long operand2, Long expected) {
        Long result = Operator.calculate(getTestCalculatorValue(operator, operand1, operand2));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "*|     4|      2|      8",
            "*|    -4|      2|     -8",
            "*|     0|      3|      0"
    }, delimiter = '|')
    @DisplayName("곱셈 연산 검증")
    void multiply(String operator, Long operand1, Long operand2, Long expected) {
        Long result = Operator.calculate(getTestCalculatorValue(operator, operand1, operand2));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "/|     4|      2|      2",
            "/|    -4|     -2|      2",
            "/|     0|      3|      0"
    }, delimiter = '|')
    @DisplayName("나눗셈 연산 검증")
    void divide(String operator, Long operand1, Long operand2, Long expected) {
        Long result = Operator.calculate(getTestCalculatorValue(operator, operand1, operand2));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "/|     4|      0",
            "/|     4|      3"
    }, delimiter = '|')
    @DisplayName("나눗셈 연산 예외 검증")
    void divideException(String operator, Long operand1, Long operand2) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.calculate(getTestCalculatorValue(operator, operand1, operand2)));
    }

    private CalculatorValue getTestCalculatorValue(String operator, Long operand1, Long operand2) {
        return CalculatorValue.of(operator, operand1, operand2);
    }
}
