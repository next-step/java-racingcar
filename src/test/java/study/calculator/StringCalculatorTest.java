package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @DisplayName("문자열 계산기 정상 입력시 결과값 유효성 Test")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "3 + -1:2", "11 * 2 - 22 * 7:0"}, delimiter = ':')
    void calculationTest(String input, String expectValue){
        String result = StringCalculator.getCalculationResult(input);
        assertEquals(expectValue, result);
    }

    @DisplayName("0 나누기 Exception Test")
    @Test
    void divisionByZeroExceptionTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String result = StringCalculator.getCalculationResult("3 / 0");
        }).withMessageContaining(CustomErrorMessage.DIVISION_BY_ZERO.getErrorMessage());
    }

    @DisplayName("입력값이 비어있는 경우에 대한 Test")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void emptyInputExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String result = StringCalculator.getCalculationResult(input);
        }).withMessageContaining(CustomErrorMessage.EMPTY_INPUT.getErrorMessage());
    }

    @DisplayName("연산자가 유효하지 않는 경우에 대한 Test")
    @ParameterizedTest
    @ValueSource(strings = {"3 & 4 % 1 + 6", "5 @ 6"})
    void illegalOperatorExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String result = StringCalculator.getCalculationResult(input);
        }).withMessageContaining(CustomErrorMessage.ILLEGAL_OPERATOR.getErrorMessage());
    }

    @DisplayName("피연산자가 정수형 숫자가 아닌 경우에 대한 Test")
    @ParameterizedTest
    @ValueSource(strings = {"q + 3", "* * 1", "0.5 + 0.4"})
    void illegalOperandExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String result = StringCalculator.getCalculationResult(input);
        }).withMessageContaining(CustomErrorMessage.ILLEGAL_OPERAND.getErrorMessage());
    }

    @DisplayName("입력값이 정상적으로 완성되지 않은 경우에 대한 Test")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 7 /", "3 * 3 - 1 -"})
    void uncompletedInputExceptionTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String result = StringCalculator.getCalculationResult(input);
        }).withMessageContaining(CustomErrorMessage.UNCOMPLETED_INPUT.getErrorMessage());
    }


}
