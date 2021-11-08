package step2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2=3", "2 - 1=1", "1 * 3=3", "6 / 2=3", "2 + 3 * 4 / 2=10"}, delimiter = '=')
    void calculateSuccess(Expression input, MyNumber res) {
        assertEquals(Calculator.calculate(input), res);
    }

    @ParameterizedTest
    @ValueSource(strings = {"null", "     ", "3 ^ 2"})
    void calculateFailBecauseIllegalArguments(String expression) {
        assertThatThrownBy(() -> Calculator.calculate(new Expression(expression)))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
