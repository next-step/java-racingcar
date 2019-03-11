package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void 덧셈() {
        int result = StringCalculator.convertToExpressionUnit("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.convertToExpressionUnit("2 - 2");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.convertToExpressionUnit("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.convertToExpressionUnit("4 / 2");
        assertThat(result).isEqualTo(2);
    }
}
