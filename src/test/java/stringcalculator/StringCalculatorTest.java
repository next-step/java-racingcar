package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
