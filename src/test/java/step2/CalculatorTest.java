package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(value = {"5 + 7:12", "13 - 5:8", "23 * 3:69", "72 / 6:12", "30 + 45 - 7:68", "10 + 11 - 7 * 4 / 7:8"}, delimiter = ':')
    public void expressionTest(String expression, int expectedValue) {

        assertThat(Calculator.calculate(expression)).isEqualTo(expectedValue);
    }

    @ParameterizedTest(name = "{0} cause illegalArgumentException")
    @ValueSource(strings = {"5 + ", "a + 3", "3 ^ 6", " "})
    public void illegalArgumentExceptionTest(String expression) {
        assertThatThrownBy(() -> Calculator.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0} cause ArithmeticException")
    @ValueSource(strings = {"5 / 0", "17 / 0"})
    public void arithmeticExceptionTest(String expression) {
        assertThatThrownBy(() -> Calculator.calculate(expression))
                .isInstanceOf(ArithmeticException.class);
    }

}
