package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("덧셈")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "4:5:9"}, delimiter = ':')
    void add(double num1, double num2, double expected) {
        double result = stringCalculator.calculate("+", num1, num2);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("뺄셈")
    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "9:3:6"}, delimiter = ':')
    void subtract(double num1, double num2, double expected) {
        double result = stringCalculator.calculate("-", num1, num2);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("곱셈")
    @ParameterizedTest
    @CsvSource(value = {"1:-2:-2", "6:7:42", "0:4:0"}, delimiter = ':')
    void multiply(double num1, double num2, double expected) {
        double result = stringCalculator.calculate("*", num1, num2);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("나눗셈")
    @ParameterizedTest
    @CsvSource(value = {"1:-2:-0.5", "4:2:2", "0:4:0"}, delimiter = ':')
    void divide(double num1, double num2, double expected) {
        double result = stringCalculator.calculate("/", num1, num2);
        assertThat(result).isEqualTo(expected);
    }
}
