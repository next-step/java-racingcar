package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    private static final String OPERATOR_INVALID_MESSAGE = "연산자가 사칙연산이 아님";
    private static final String OPERAND_INVALID_MESSAGE = "피연산자가 숫자가 아님";

    @DisplayName("사용자의 input을 계산 : success")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 2 + 3:6", "5 / 2:2.5", "2 * 3 / 2:3", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    public void calculateUserInput_success(String input, double expect) throws Exception {
        //given
        String[] inputSplit = new InputVo(input).getInputSplit();
        Calculator calculator = new Calculator(inputSplit);

        //when
        double result = calculator.calculateUserInput();

        //then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("사칙연산이 아닌 문자가 input 됐을 때 : fail")
    @ParameterizedTest
    @ValueSource(strings = {"1 @ 2", "1 1 2 1", "5 a 2"})
    public void validateOperator_fail(String input) throws Exception {
        //given
        String[] inputSplit = new InputVo(input).getInputSplit();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator(inputSplit);
                }).withMessageContaining(OPERATOR_INVALID_MESSAGE);
    }

    @DisplayName("연산자가 사칙연산이 아닌 문자 일때")
    @ParameterizedTest
    @ValueSource(strings = {"1 @ 2", "1 1 2 1", "5 a 2"})
    public void validateOperator(String input) throws Exception {
        //given
        String[] inputSplit = new InputVo(input).getInputSplit();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator(inputSplit);
                }).withMessageContaining(OPERATOR_INVALID_MESSAGE);
    }

    @DisplayName("피연산자가 숫자가 아닐때")
    @ParameterizedTest
    @ValueSource(strings = {"a - 1", "1 * 2 - -", "+ + +"})
    public void validateOperand(String input) throws Exception {
        //given
        String[] inputSplit = new InputVo(input).getInputSplit();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator(inputSplit);
                }).withMessageContaining(OPERAND_INVALID_MESSAGE);
    }
}
