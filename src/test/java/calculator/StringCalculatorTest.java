package calculator;

import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {


    @Test(expected = NumberFormatException.class)
    public void 숫자인지_판단_슷자가아닌경우() {
        StringCalculator.checkNumber("x");
    }

    @Test
    public void 숫자인지_판단_숫자인경우() {
        assertThat(StringCalculator.checkNumber("2")).isEqualTo(2);
    }

    @Test(expected = NullPointerException.class)
    public void 널혹은공백일경우예외처리() {
        StringCalculator.checkNull(" ");
    }

    @Test
    public void 계산기_덧셈() {
        assertThat(StringCalculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    public void 계산기_뺄셈() {
        assertThat(StringCalculator.sub(2, 1)).isEqualTo(1);
    }

    @Test
    public void 계산기_곱셉() {
        assertThat(StringCalculator.multi(2, 3)).isEqualTo(6);
    }

    @Test
    public void 계산기_나눗셈() {
        assertThat(StringCalculator.div(2, 2)).isEqualTo(1);
    }

    @Test
    public void 계산하기() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }


}