package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculate("5 * 4");
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculate("5 - 4");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculate("10 / 2");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void calculate() {
        int result = StringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

}