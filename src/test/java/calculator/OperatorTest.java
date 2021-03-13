package calculator;

import calculator.enums.OperatorEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    private static final String STR_ADD = "+";
    private static final String STR_SUBTRACT = "-";
    private static final String STR_DIVIDE = "/";
    private static final String STR_MULTIPLY = "*";

    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for add function")
    void testAdd(int num1, int num2) {
        assertThat(OperatorEnum.getOperator(STR_ADD).operate(num1, num2))
                        .isEqualTo(num1+num2);
    }


    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for subtract function")
    void testSubtract(int num1, int num2) {
        assertThat(OperatorEnum.getOperator(STR_SUBTRACT).operate(num1, num2))
                .isEqualTo(num1-num2);
    }


    @ParameterizedTest
    @CsvSource(value = {"10:5", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for divide function")
    void testDivide(int num1, int num2) {
        assertThat(OperatorEnum.getOperator(STR_DIVIDE).operate(num1, num2))
                .isEqualTo(num1/num2);
    }


    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for multiply function")
    void testMultiply(int num1, int num2) {
        assertThat(OperatorEnum.getOperator(STR_MULTIPLY).operate(num1, num2))
                .isEqualTo(num1*num2);
    }

}
