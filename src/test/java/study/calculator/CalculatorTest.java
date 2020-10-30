package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource(value = {"2 + 3,5", "1 + 1 + 3, 5"}, delimiter = ',')
    @DisplayName("덧셈")
    void test_plus(String expression, Integer result) {
        assertEquals(calculator.calculate(new Expression(expression)), result);
    }

    @ParameterizedTest
    @CsvSource(value = {"7 - 4,3", "9 - 2 - 5,2"}, delimiter = ',')
    @DisplayName("뺄셈")
    void test_minus(String expression, Integer result) {
        assertEquals(calculator.calculate(new Expression(expression)), result);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 3,6", "3 * 4 * 5,60"}, delimiter = ',')
    @DisplayName("곱셈")
    void test_multiply(String expression, Integer result) {
        assertEquals(calculator.calculate(new Expression(expression)), result);
    }

    @ParameterizedTest
    @CsvSource(value = {"12 / 4,3", "24 / 2 / 3,4"}, delimiter = ',')
    @DisplayName("나눗셈")
    void test_division(String expression, Integer result) {
        assertEquals(calculator.calculate(new Expression(expression)), result);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("NullSource")
    void test_nullsource(String expression) {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(new Expression(expression));
        });
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("EmptySource")
    void test_blanksource(String expression) {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(new Expression(expression));
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 - 1 * 5 / 4,5", "60 / 12 * 7 + 5 - 20,20"}, delimiter = ',')
    @DisplayName("모든 사칙연산 포함")
    void test_all_operator(String expression, Integer result) {
        assertEquals(calculator.calculate(new Expression(expression)), result);
    }
}