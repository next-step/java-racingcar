package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    void testAddTwoNumbers() {
        // Given
        String expression = "1 + 2";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testAddFourNumbers() {
        // Given
        String expression = "1 + 2 + 5 + 5";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(13);
    }

    @Test
    void testMinusTwoNumbers() {
        // Given
        String expression = "3 - 1";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void testMinusFourNumbers() {
        // Given
        String expression = "5 - 2 - 1 - 1";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testMultiplyTwoNumbers() {
        // Given
        String expression = "2 * 3";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void testMultiplyFourNumbers() {
        // Given
        String expression = "1 * 2 * 3 * 4";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(24);
    }

    @Test
    void testDividedByTwoNumbers() {
        // Given
        String expression = "6 / 2";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testDividedByFourNumbers() {
        // Given
        String expression = "100 / 5 / 2 / 2";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testDividedByZeroShouldThrowIllegalArgumentException() {
        // Given
        String expression = "30 / 0";

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                calculator.calculate(expression)
        );
    }

    @Test
    void testAllOfKindsOperations() {
        // Given
        String expression = "5 + 3 / 4 * 10";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(20);
    }

    @Test
    void invalidOperatorShouldThrowIllegalArgumentException() {
        // Given
        String invalidExpression = "1 + 3 ^ 5";

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                calculator.calculate(invalidExpression)
        );
    }

    @ParameterizedTest(name = "{0} input should throw IllegalArgumentException ")
    @MethodSource("invalidInputs")
    void testNullInputOrEmptyInputShouldThrowIllegalArgumentException(String expression) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                calculator.calculate(expression)
        );
    }

    static Stream<String> invalidInputs() {
        return Stream.of(
                "",
                null
        );
    }
}
