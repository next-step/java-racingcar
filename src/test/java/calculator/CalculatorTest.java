package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest {

    @Test
    public void add() {
        int result = Calculator.add(3, 5);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void sub() {
        int result = Calculator.sub(5, 6);
        assertThat(result).isEqualTo(-1);
    }
}