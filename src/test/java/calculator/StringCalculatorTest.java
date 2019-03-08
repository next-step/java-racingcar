package calculator;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculate("1 - 2");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculate("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculate("1 / 2");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 문자열계산() {
        int result = StringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 빈공백입력_예외처리() {
        int result = StringCalculator.calculate("");
        assertThat(result).isEqualTo(-9999);
    }

    @Test
    public void NULL입력_예외처리() {
        int result = StringCalculator.calculate(null);
        assertThat(result).isEqualTo(-9999);
    }
}