package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    @Test
    public void 덧셈() {
        int result = StringCalculator.calculator("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculator("2 - 3");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void 곱셉() {
        int result = StringCalculator.calculator("2 * 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 나누기() {
        int result = StringCalculator.calculator("10 / 2");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 사칙연산() {
        int result = StringCalculator.calculator("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}