package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator(2);
    }

    @Test
    public void getTotalTest() {
        assertThat(calculator.getTotal()).isEqualTo(2);
    }

    @Test
    public void addTest() {
        assertThat(calculator.add(2).getTotal()).isEqualTo(4);
        assertThat(calculator.getTotal()).isEqualTo(4);
    }

    @Test
    public void subtractTest() {
        assertThat(calculator.subtract(1).getTotal()).isEqualTo(1);
        assertThat(calculator.getTotal()).isEqualTo(1);
    }

    @Test
    public void multiplyTest() {
        assertThat(calculator.multiply(3).getTotal()).isEqualTo(6);
        assertThat(calculator.getTotal()).isEqualTo(6);
    }

    @Test
    public void divideTest() {
        assertThat(calculator.divide(2).getTotal()).isEqualTo(1);
        assertThat(calculator.getTotal()).isEqualTo(1);
    }
}