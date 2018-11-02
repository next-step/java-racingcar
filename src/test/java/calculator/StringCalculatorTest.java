package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculator("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 빼기() {
        int result = StringCalculator.calculator("5 - 3");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculator("2 * 3");
        assertThat(result).isEqualTo(6);
    }


    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculator("4 / 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 덧셈곱셈() {
        int result = StringCalculator.calculator("2 + 3 * 2");
        assertThat(result).isEqualTo(10);
    }
}