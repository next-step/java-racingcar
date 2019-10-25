package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
         stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2"}, delimiter = ',')
    void plus(int operand1, int operand2) {
        int result = stringCalculator.plus(operand1, operand2);
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2"}, delimiter = ',')
    void minus(int operand1, int operand2) {
        int result = stringCalculator.minus(operand1, operand2);
        assertThat(result).isEqualTo(-1);
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 3"}, delimiter = ',')
    void multiply(int operand1, int operand2) {
        int result = stringCalculator.multiply(operand1, operand2);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 2"}, delimiter = ',')
    void divide(int operand1, int operand2) {
        int result = stringCalculator.divide(operand1, operand2);
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "      "})
    void input_ShouldReturnIllegalArgumentExceptionForEmptyString(String expression) {
        assertThatThrownBy(() -> {
            stringCalculator.input(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    void input_ShouldReturnIllegalArgumentExceptionForNull(String expression) {
        assertThatThrownBy(() -> {
            stringCalculator.input(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 ! 4 . 3 & 2 @ 3"})
    void validateOperators(String expression) {
        assertThatThrownBy(() -> {
            stringCalculator.validateOperators(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
