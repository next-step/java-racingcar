package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 6:18"}, delimiter = ':')
    void calculateTest(String expression, String result) {
        assertThat(Calculator.calculate(expression, NumberType.INTEGER).toString()).isEqualTo(result);
    }
}
