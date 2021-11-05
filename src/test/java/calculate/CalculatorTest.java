package calculate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add() {
        assertThat(calculator.calculate("1 + 3")).isEqualTo(4);
    }

    @Test
    void subtract() {
        assertThat(calculator.calculate("1 - 3")).isEqualTo(-2);
    }

    @Test
    void multiply() {
        assertThat(calculator.calculate("4 * 3")).isEqualTo(12);
    }

    @Test
    void divide() {
        assertThat(calculator.calculate("6 / 3")).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 / 3 * 4 / 2:0", "2 * 3 / 4 + 2:3"}, delimiter = ':')
    void composite(String composite, int expectedResult) {
        assertThat(calculator.calculate(composite)).isEqualTo(expectedResult);
    }
}
