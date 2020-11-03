package string.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import string.calculator.OperationsDivision;
import string.calculator.Operator;
import string.calculator.StringCalculator;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    private StringCalculator calculator;
    private OperationsDivision operationsDivision;

    @BeforeEach
    void setup() {
        calculator = new StringCalculator();
        operationsDivision = new OperationsDivision();
    }

    /**
     * OperationsDivision test
     **/
    @DisplayName("올바른 입력일 때, 피연산자가 제대로 추출됐는지 확인")
    @Test
    void verifyExtractValidOperand() {
        String input = "2 + 3 * 4 / 2";

        LinkedList<String> operands = operationsDivision.extractOperands(input);
        assertThat(operands).isNotNull();
    }

    @DisplayName("올바른 입력일 때, 연산자가 제대로 추출됐는지 확인")
    @Test
    void verifyExtractValidOperator() {
        String input = "2 + 3 * 4 / 2";

        LinkedList<Operator> operands = operationsDivision.extractOperators(input);
        assertThat(operands).isNotNull();
    }

    @DisplayName("올바르지 않은 입력일 때, 피연산자가 제대로 예외처리 되었는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "2+3*4/2 : 올바른 사칙연산을 입력해야 합니다.",
            "** : 올바른 사칙연산을 입력해야 합니다.",
            "2 ** : 올바른 사칙연산을 입력해야 합니다.",
            "// 2 : 올바른 사칙연산을 입력해야 합니다.",
    }, delimiter = ':')
    void verifyExceptionWhenExtractingOperatorWithInvalidInput(String input, String exceptionMessage) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> operationsDivision.extractOperators(input))
                .withMessageMatching(exceptionMessage);
    }

    /**
     * Operator test
     **/
    @DisplayName("사칙연산이 제대로 이루어졌는지 동작확인")
    @ParameterizedTest
    @CsvSource(value = {
            "ADD : 7",
            "SUBTRACT : -1",
            "MULTIPLE : 12",
            "DIVISION : 0",
    }, delimiter = ':')
    void verifyAdd(String operator, String expected) {
        String firstNum = "3";
        String secondNum = "4";

        String result = Operator.valueOf(operator).calculate(firstNum, secondNum);
        assertThat(result).isEqualTo(expected);
    }

    /**
     * StringCalculator test
     **/
    @DisplayName("올바른 입력 일 때 올바른 결과값 확인.")
    @Test
    void verifyResultWhenValidInput() {
        String input = "2 + 3 * 4 / 2";
        String result = calculator.getResult(input, operationsDivision);
        assertThat(result).isEqualTo("10");
    }

    @DisplayName("올바르지 않은 input이 들어갔을 때 동작확인")
    @ParameterizedTest
    @CsvSource(value = {
            "' ' : null 혹은 빈 값이 올 수 없습니다.",
            " : null 혹은 빈 값이 올 수 없습니다.",
            "* : 잘못된 입력 입니다."
    }, delimiter = ':')
    void verifyCalculatorWhenInvalidInput(String input, String expectedMessage) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.getResult(input, operationsDivision))
                .withMessageMatching(expectedMessage);
    }
}