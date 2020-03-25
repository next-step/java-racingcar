package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    private static final String OPERATOR_INVALID_MESSAGE = "연산자가 사칙연산이 아님";
    private static final String OPERAND_INVALID_MESSAGE = "피연산자가 숫자가 아님";

    @DisplayName("사용자의 input을 계산 : success")
    @Test
    public void calculateUserInput_success() throws Exception {
        //given
        String[] inputSplit = {"1", "+", "2"};
        Calculator calculator = new Calculator(inputSplit);

        //when
        double result = calculator.calculateUserInput();

        //then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("사칙연산이 아닌 문자가 input 됐을 때 : fail")
    @Test
    public void validateOperator_fail() throws Exception {
        //given
        String[] inputSplit = {"5", "a", "2"};

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator(inputSplit);
                }).withMessageContaining(OPERATOR_INVALID_MESSAGE);
    }

    @DisplayName("연산자가 사칙연산이 아닌 문자 일때")
    @Test
    public void validateOperator() throws Exception {
        //given
        String[] inputSplit = {"1", "@", "2"};

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator(inputSplit);
                }).withMessageContaining(OPERATOR_INVALID_MESSAGE);
    }

    @DisplayName("피연산자가 숫자가 아닐때")
    @Test
    public void validateOperand() throws Exception {
        //given
        String[] inputSplit = {"a", "-", "1"};

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator(inputSplit);
                }).withMessageContaining(OPERAND_INVALID_MESSAGE);
    }
}
