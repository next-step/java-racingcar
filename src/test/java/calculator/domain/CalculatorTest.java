package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void add() {
        int result = Calculator.add(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void sub() {
        int result = Calculator.sub(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void mul() {
        int result = Calculator.mul(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void div() {
        int result = Calculator.div(6, 3);
        assertThat(result).isEqualTo(2);
    }

}