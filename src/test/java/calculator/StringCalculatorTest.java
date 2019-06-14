package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringCalculatorTest {

    @Test
    public void 사칙연산() {
        int result = StringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 사칙연산2() {
        int result = StringCalculator.calculate("1 * 4 * 2");
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculate("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculate("1 - 3");
        assertThat(result).isEqualTo(-2);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculate("4 / 2");
        assertThat(result).isEqualTo(2);
    }
}