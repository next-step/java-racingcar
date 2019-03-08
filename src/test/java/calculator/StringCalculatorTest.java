package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void 계산() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 계산기_덧셈() {
        int result = StringCalculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 계산기_뺄셈() {
        int result = StringCalculator.sub(2, 1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 계산기_곱셉() {
        int result = StringCalculator.multi(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 계산기_나눗셈() {
        assertThat(StringCalculator.div(2, 2)).isEqualTo(1);
    }

    @Test
    public void 구분자나열() {
//       String[] strings = StringCalculator.getList("1 + 2");
//       assertThat(
    }
}