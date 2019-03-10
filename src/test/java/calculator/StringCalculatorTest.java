package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void add() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void multiply() {
        int result = StringCalculator.calculate("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void subtract() {
        int result = StringCalculator.calculate("2 - 1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void divide() {
        int result = StringCalculator.calculate("4 / 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void multipleOperation() {
        int result = StringCalculator.calculate("2 + 3 * 4");
        assertThat(result).isEqualTo(20);
    }
}