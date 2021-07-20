package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {


    public static Calculator calculator = new Calculator();


    @Test
    void plusTest () {
        int result = 10;
        assertEquals(calculator.plus(1, 10),result + 1);
    }

    @Test
    void minusTest () {
        int result = 10;
        assertEquals(calculator.minus(1, 10),result - 1);
    }

    @Test
    void mutiplyTest () {
        int result = 10;
        assertEquals(calculator.multiply(2, 10),result * 2);
    }

    @Test
    void divideTest () {
        int result = 10;
        assertEquals(calculator.divide(2, 10),result / 2);
    }

    @Test
    void splitTest () {
        String[] result = "2 + 3 * 4 / 2".split(" ");
        assertThat(result).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    void calculatorTest () {
        String[] result = "2 + 3 * 4 / 2".split(" ");
        int cal = calculator.calculator(result);
        assertEquals(cal,10);
    }

}
