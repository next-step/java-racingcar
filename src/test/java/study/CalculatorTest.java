package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator = new Calculator("2 + 3 * 4 / 2");

    @Test
    void plus() {
        assertThat(calculator.plus(1, 2)).isEqualTo(3);
    }

    @Test
    void minus() {
        assertThat(calculator.minus(2, 1)).isEqualTo(1);
    }

    @Test
    void multiply() {
        assertThat(calculator.multiplied(2, 3)).isEqualTo(6);
    }

    @Test
    void divide() {
        assertThat(calculator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    void operator() {
        assertThat(calculator.calculation()).isEqualTo(10);
    }
}
