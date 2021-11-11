package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.model.Calculator;
import step2.model.Operator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("Operator test")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1 - 5 + 10 / 7 * 100:100", "100 * 100:10000", " 100 / 100:1"}, delimiter = ':')
    void calculator(String str, int expect) {
        assertEquals(Calculator.calculateAll(str), expect);
    }

    @DisplayName("divide by zero exception test")
    @ParameterizedTest
    @CsvSource(value = {"100 / 0:1"}, delimiter = ':')
    void divideByZeroException(String str, int expect) {
        assertThatThrownBy(() -> {
            Calculator.calculateAll(str);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("can't divide by zero");
    }

    @Test
    void findOperatorTest() {
        Operator ADD = Operator.findOperator("+");
        assertEquals(ADD, Operator.ADD);

        Operator MINUS = Operator.findOperator("-");
        assertEquals(MINUS, Operator.MINUS);

        Operator DIVIDE = Operator.findOperator("/");
        assertEquals(DIVIDE, Operator.DIVIDE);

        Operator MULTIPLY = Operator.findOperator("*");
        assertEquals(MULTIPLY, Operator.MULTIPLY);
    }
    @Test
    void calculatorTwoNumberTest() {
        Integer addNum = Operator.calculator(1, 3, Operator.ADD);
        assertEquals(addNum,4);

        Integer multiplyNum = Operator.calculator(1, 3, Operator.MULTIPLY);
        assertEquals(multiplyNum,3);

        Integer minusNum = Operator.calculator(6, 3, Operator.MINUS);
        assertEquals(minusNum,3);

        Integer divideNum = Operator.calculator(30, 3, Operator.DIVIDE);
        assertEquals(divideNum,10);
    }


}
