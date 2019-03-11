package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {
    @Test
    public void 덧셈() {
        int result = StringCalculator.run("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.run("2 - 1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.run("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.run("10 / 2");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 사칙연산() {
        int result = StringCalculator.run("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}