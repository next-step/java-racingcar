package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void 덧셈() {
        assertThat(StringCalculator.calculate("1+2")).isEqualTo(3);
        assertThat(StringCalculator.calculate("1+2+3")).isEqualTo(6);
    }

    @Test
    public void 뺄셈() {
        assertThat(StringCalculator.calculate("3-1")).isEqualTo(2);
    }
}