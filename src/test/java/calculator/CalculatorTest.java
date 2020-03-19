package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("피연산자가 숫자인지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "29", "10000", "2222"})
    public void validateOperand1(String operand) throws Exception {
        //then
        Calculator.validateOperand(operand);
    }

    @DisplayName("피연산자가 숫자인지 체크 - fail 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1ㅁ", "2d", "d", "-", "29`", "100~00", "^"})
    public void validateOperand2(String operand) throws Exception {
        //then
        assertThatThrownBy(() -> {
            Calculator.validateOperand(operand);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("연산자가 사칙연산인지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    public void validateOperator1(String operator) throws Exception {
        //then
        Calculator.validateOperator(operator);
    }

    @DisplayName("연산자가 사칙연산인지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"++", "/-", "--", "***", "1", "ㅁ", "a"})
    public void validateOperator2(String operator) throws Exception {
        //then
        assertThatThrownBy(() -> {
            Calculator.validateOperator(operator);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}