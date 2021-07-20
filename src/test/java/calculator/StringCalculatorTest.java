package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4","5"})
    @DisplayName("피연산자 정규식 테스트")
    public void isOperand(String operand) {
        boolean checkOperand = stringCalculator.isOperand(operand);
        assertThat(checkOperand).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+","*","-","/"})
    @DisplayName("연산자 정규식 테스트")
    public void isOperator(String operator) {
        boolean checkOperator = stringCalculator.isOperator(operator);
        assertThat(checkOperator).isEqualTo(true);
    }

    @Test
    @DisplayName("계산기 결과값 확인")
    void execute() {
        String expression = "3 + 4 * 5 / 4";
        int result = stringCalculator.execute(expression);
        assertThat(result).isEqualTo(8);
    }
}
