package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void add() {
        int number = Calculator.add(1, 2);

        assertThat(number).isEqualTo(3);
    }

    @Test
    void subtract() {
        int number = Calculator.subtract(1, 2);

        assertThat(number).isEqualTo(-1);
    }

    @Test
    void multiply() {
        int number = Calculator.multiply(1, 2);

        assertThat(number).isEqualTo(2);
    }

    @Test
    void divide() {
        double number = Calculator.divide(1, 2);

        assertThat(number).isEqualTo(0.5);
    }
}
