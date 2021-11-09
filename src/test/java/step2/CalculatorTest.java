package step2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3=6", "6 - 3 - 3=0", "2 + 3 * 4 / 2=10"}, delimiter = '=')
    void calculator(Expression expression, Operand ans) {
        assertEquals(ans, Calculator.calculate(expression));
    }

    @Test
    void nullInput() {
        assertThatThrownBy(() -> Calculator.calculate(new Expression(null)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyInput() {
        assertThatThrownBy(() -> Calculator.calculate(new Expression("   ")))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
