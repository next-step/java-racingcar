package stringCalculator;

import org.junit.jupiter.api.Assertions;
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
        calculator.add(2);
        assertThat(calculator.getTotal()).isEqualTo(4);
    }

    @Test
    public void subtractTest() {
        calculator.subtract(1);
        assertThat(calculator.getTotal()).isEqualTo(1);
    }

    @Test
    public void multiplyTest() {
        calculator.multiply(3);
        assertThat(calculator.getTotal()).isEqualTo(6);
    }

    @Test
    public void divideTest() {
        calculator.divide(2);
        assertThat(calculator.getTotal()).isEqualTo(1);
    }

    @Test
    public void divideZeroExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            assertThat(calculator.divide(0));
        });

    }
}