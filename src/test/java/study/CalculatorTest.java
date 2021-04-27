package study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"1,5"})
    void add(String input, String expected) {
        Calculator calculator = new Calculator();

        int a = Integer.parseInt(input);
        int b = Integer.parseInt(expected);

        int result = calculator.add(a, b);

        assertThat(6).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"5,1"})
    void subtract(String input, String expected) {
        Calculator calculator = new Calculator();

        int a = Integer.parseInt(input);
        int b = Integer.parseInt(expected);

        int result = calculator.subtract(a, b);

        assertThat(4).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"1,5"})
    void multiply(String input, String expected) {
        Calculator calculator = new Calculator();

        int a = Integer.parseInt(input);
        int b = Integer.parseInt(expected);

        int result = calculator.multiply(a, b);

        assertThat(5).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"6,3"})
    void divide(String input, String expected) {
        Calculator calculator = new Calculator();

        int a = Integer.parseInt(input);
        int b = Integer.parseInt(expected);

        int result = calculator.divide(a, b);

        assertThat(2).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        Calculator calculator = new Calculator();
        assertTrue(calculator.isBlank(input));
    }

    @Test
    void calculator() {
        assertThatThrownBy(() -> {
            Calculator calculator = new Calculator();

            int result = calculator.calculate(1, '+', 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}