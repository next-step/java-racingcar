package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void validate_ShouldReturnIllegalArgumentExceptionForEmptyString(String expression) {
        assertThatThrownBy(() -> {
            stringCalculator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    void validate_ShouldReturnIllegalArgumentExceptionForNull(String expression) {
        assertThatThrownBy(() -> {
            stringCalculator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 ! 4 . 3 & 2 @ 3"})
    void validate_ShouldReturnIllegalArgumentExceptionForWrongOperator(String expression) {
        assertThatThrownBy(() -> {
            stringCalculator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 + 4 - a * 2 / 3"})
    void validate_ShouldReturnIllegalArgumentExceptionForWrongOperand(String expression) {
        assertThatThrownBy(() -> {
            stringCalculator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 + 4 - 3 * 2 / 3 +"})
    void validate_ShouldReturnIllegalArgumentExceptionForMissingOperand(String expression) {
        assertThatThrownBy(() -> {
            stringCalculator.validate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate_ShouldReturnIllegalArgumentExceptionForNullExpression() {
        assertThatThrownBy(() -> {
            stringCalculator.calculate();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 + 4 - 3 * 2 / 3"})
    void calculate(String expression) {
        stringCalculator.validate(expression);
        int result = stringCalculator.calculate();
        assertThat(result).isEqualTo(4);
    }
}
