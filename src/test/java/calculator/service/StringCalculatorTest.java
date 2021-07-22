package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "-", "/"})
    @DisplayName("피연산자 정규식 예외 테스트")
    public void isOperand(String operand) {
        assertThatThrownBy(
                () ->   stringCalculator.isOperand(operand)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"^", "@", "!"})
    @DisplayName("연산자 정규식 예외 테스트")
    public void isOperator(String operator) {
        assertThatThrownBy(
                () ->   stringCalculator.isOperand(operator)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10 * 1 - 1 + 5,14",
            "20 * 2 - 2 + 5,43",
            "30 * 3 - 3 + 5,92",
            "40 * 4 - 4 + 5,161"
    })
    @DisplayName("계산기 결과값 확인")
    void execute(String expression, int expected) {
        int result = stringCalculator.execute(expression);
        assertThat(result).isEqualTo(expected);
    }

}
