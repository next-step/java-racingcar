package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void testAddTwoNumbers() {
        // Given
        StringCalculator calculator = new StringCalculator();
        String expression = "1 + 2";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testAddFourNumbers() {
        // Given
        StringCalculator calculator = new StringCalculator();
        String expression = "1 + 2 + 5 + 5";

        // When
        int result = calculator.calculate(expression);

        // Then
        assertThat(result).isEqualTo(13);
    }
}
