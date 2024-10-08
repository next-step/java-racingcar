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
        double number = Calculator.divide(2, 2);

        assertThat(number).isEqualTo(1);
    }

    @Test
    void run() {
        InputString inputString = new InputString("2 + 3 * 4 / 2");

        int result = Calculator.run(inputString);

        assertThat(result).isEqualTo(10);
    }
}
