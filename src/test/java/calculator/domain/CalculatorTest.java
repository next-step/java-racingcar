package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void add() {
        long result = Calculator.add(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void sub() {
        long result = Calculator.subtract(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void mul() {
        long result = Calculator.multiply(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void div() {
        long result = Calculator.divide(6, 3);
        assertThat(result).isEqualTo(2);
    }

}