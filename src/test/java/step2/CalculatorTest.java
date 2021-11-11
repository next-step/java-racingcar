package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.model.Calculator;
import step2.model.CalculatorEnum;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("Operator test")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1 - 5 + 10 / 7 * 100:100", "100 * 100:10000", " 100 / 100:1"}, delimiter = ':')
    void calculator(String str, int expect) {
        assertEquals(Calculator.operator(str), expect);
    }

    @DisplayName("divide by zero exception test")
    @ParameterizedTest
    @CsvSource(value = {"100 / 0:1"}, delimiter = ':')
    void divideByZeroException(String str, int expect) {
        assertThatThrownBy(() -> {
            Calculator.operator(str);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("can't divide by zero");
    }

    @Test
    void findOperatorTest() {
        CalculatorEnum ADD = CalculatorEnum.findOperator("+");
        assertEquals(ADD,CalculatorEnum.ADD);

        CalculatorEnum MINUS = CalculatorEnum.findOperator("-");
        assertEquals(MINUS,CalculatorEnum.MINUS);

        CalculatorEnum DIVIDE = CalculatorEnum.findOperator("/");
        assertEquals(DIVIDE,CalculatorEnum.DIVIDE);

        CalculatorEnum MULTIPLY = CalculatorEnum.findOperator("*");
        assertEquals(MULTIPLY,CalculatorEnum.MULTIPLY);
    }
    @Test
    void calculatorTwoNumberTest() {
        Integer addNum = CalculatorEnum.calculator(1, 3, CalculatorEnum.ADD);
        assertEquals(addNum,4);

        Integer multiplyNum = CalculatorEnum.calculator(1, 3, CalculatorEnum.MULTIPLY);
        assertEquals(multiplyNum,3);

        Integer minusNum = CalculatorEnum.calculator(6, 3, CalculatorEnum.MINUS);
        assertEquals(minusNum,3);

        Integer divideNum = CalculatorEnum.calculator(30, 3, CalculatorEnum.DIVIDE);
        assertEquals(divideNum,10);
    }


}
