package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void 덧셈() {
        assertThat(Calculator.calculate("3 + 4")).isEqualTo(7);
    }

    @Test
    void 뺼셈() {
        assertThat(Calculator.calculate("8 - 4")).isEqualTo(4);
    }

    @Test
    void 곱셈() {
        assertThat(Calculator.calculate("3 * 4")).isEqualTo(12);
    }

    @Test
    void 나눗셈() {
        assertThat(Calculator.calculate("20 / 5")).isEqualTo(4);
    }
}