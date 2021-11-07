package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = { "1 + 2:3", "-1 + 2:1" }, delimiter = ':')
    void plus(String expression, int expected) {
        int result = Calculator.calculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 - 2:-1", "-1 - 2:-3" }, delimiter = ':')
    void minus(String expression, int expected) {
        int result = Calculator.calculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 * 2:2", "-1 * 2:-2" }, delimiter = ':')
    void times(String expression, int expected) {
        int result = Calculator.calculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "4 / 2:2", "-2 / 2:-1" }, delimiter = ':')
    void devidedBy(String expression, int expected) {
        int result = Calculator.calculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    private static String[] nullEmptySource() {
        return new String[] { null, "" };
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외를 던진다")
    @ParameterizedTest
    @MethodSource("nullEmptySource")
    void invalidExpression(String expression) {
        assertThatThrownBy(() -> Calculator.calculate(expression)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = { "1 ( 2", "1 ) 2" })
    void invalidOperator(String expression) {
        assertThatThrownBy(() -> Calculator.calculate(expression)).isInstanceOf(IllegalArgumentException.class);
    }
}
