package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void addition() {
        int result = Calculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtraction() {
        int result = Calculator.calculate("4 - 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiplication() {
        int result = Calculator.calculate("5 * 4");
        assertThat(result).isEqualTo(20);
    }

    @Test
    void division() {
        int result = Calculator.calculate("20 / 2");
        assertThat(result).isEqualTo(10);
    }
}
