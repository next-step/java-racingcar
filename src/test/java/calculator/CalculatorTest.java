package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void plus() {
        int acc = Calculator.calculate("1 + 2");
        assertThat(acc).isEqualTo(3);
    }

    @Test
    public void minus() {
        int acc = Calculator.calculate("3 - 2");
        assertThat(acc).isEqualTo(1);
    }

    @Test
    public void times() {

        int acc = Calculator.calculate("3 * 2");
        assertThat(acc).isEqualTo(6);
    }

    @Test
    public void dividedBy() {
        int acc = Calculator.calculate("4 / 2");
        assertThat(acc).isEqualTo(2);
    }

}
