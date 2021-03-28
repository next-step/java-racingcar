package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "5 * 3 / 5 + 7:10", "10 - 5 * 2:10", "11 / 2 * 20 + 9 - 22:87"}, delimiter = ':')
    void calculate(String input, int result) {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }
}