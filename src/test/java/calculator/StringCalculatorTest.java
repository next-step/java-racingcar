package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void sum() {
        int sum = StringCalculator.sum(3, 5);
        assertThat(sum).isEqualTo(8);
    }

    @Test
    void subtract() {
        int subtract = StringCalculator.subtract(5, 2);
        assertThat(subtract).isEqualTo(3);
    }

    @Test
    void multiply() {
        int multiply = StringCalculator.multiply(7, 3);
        assertThat(multiply).isEqualTo(21);
    }

    @Test
    void divide() {
        int divide = StringCalculator.divide(20, 4);
        assertThat(divide).isEqualTo(5);
    }
}
