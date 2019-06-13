package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    @Test
    void add() {
        assertThat(Calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    void subtract() {
        assertThat(Calculator.subtract(2, 1)).isEqualTo(1);
    }

    @Test
    void multiply() {
        assertThat(Calculator.multiply(2, 2)).isEqualTo(4);
    }

    @Test
    void divide() {
        assertThat(Calculator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    void divideBy0ThrowIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.divide(2, 0));
    }
}
