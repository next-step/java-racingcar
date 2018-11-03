package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void exception() {
        assertThat(Calculator.calculate("&", 6, 3)).isEqualTo(9);
    }

    @Test
    public void calculate() {
        assertThat(Calculator.calculate("+", 6, 3)).isEqualTo(9);
        assertThat(Calculator.calculate("-", 6, 3)).isEqualTo(3);
        assertThat(Calculator.calculate("*", 6, 3)).isEqualTo(18);
        assertThat(Calculator.calculate("/", 6, 3)).isEqualTo(2);
    }

    @Test
    public void add() {
        int result = Calculator.add(6, 3);
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void subtract() {
        int result = Calculator.subtract(6, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void multiple() {
        int result = Calculator.multiple(6, 3);
        assertThat(result).isEqualTo(18);
    }

    @Test
    public void divide() {
        int result = Calculator.divide(6, 3);
        assertThat(result).isEqualTo(2);
    }
}