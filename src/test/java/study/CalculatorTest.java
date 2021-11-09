package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void add() {
        int result = Calculator.calculate2("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        int result = Calculator.calculate2("4 - 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void multiply() {
        int result = Calculator.calculate2("5 * 4");
        assertThat(result).isEqualTo(20);
    }

    @Test
    void divide() {
        int result = Calculator.calculate2("20 / 2");
        assertThat(result).isEqualTo(10);
    }
}
