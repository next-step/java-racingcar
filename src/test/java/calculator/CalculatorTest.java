package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void add() {
        // when
        int result = Calculator.add(3, 5);

        // then
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void subtract() {
        // when
        int result = Calculator.subtract(5, 2);

        // then
        assertThat(result).isEqualTo(3);
    }
}