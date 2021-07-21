package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @DisplayName("피연산자 정규식 테스트")
    public void isOperand(String operand) {
        boolean checkOperand = stringCalculator.isOperand(operand);
        assertThat(checkOperand).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "*", "-", "/"})
    @DisplayName("연산자 정규식 테스트")
    public void isOperator(String operator) {
        boolean checkOperator = stringCalculator.isOperator(operator);
        assertThat(checkOperator).isEqualTo(true);
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
