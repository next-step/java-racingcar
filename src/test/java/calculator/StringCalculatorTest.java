package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculaor("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculaor("2 - 3");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculaor("2 * 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculaor("2 / 3");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 혼합연산() {
        int result = StringCalculator.calculaor("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}