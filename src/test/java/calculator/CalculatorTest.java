package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "5 * 3 / 5 + 7", "10 - 5 * 2"})
    void calculate(String input) {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(input)).isEqualTo(10);
    }
}