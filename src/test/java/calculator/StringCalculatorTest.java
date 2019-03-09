package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test(expected = IllegalArgumentException.class)
    public void 잘못된입력(){
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
        assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    public void 피연산자1개(){
        assertThat(StringCalculator.calculate("1")).isEqualTo(1);
        assertThat(StringCalculator.calculate("33")).isEqualTo(33);
    }

    @Test
    public void 피연산자2개_1자리수() {
        assertThat(StringCalculator.calculate("1+2")).isEqualTo(3);
        assertThat(StringCalculator.calculate("2-1")).isEqualTo(1);
        assertThat(StringCalculator.calculate("4*2")).isEqualTo(8);
    }

    @Test
    public void 피연산자2개_2자리수이상() {
        // 2글자 이상
        assertThat(StringCalculator.calculate("22+22")).isEqualTo(44);
        assertThat(StringCalculator.calculate("123*2")).isEqualTo(246);
    }

    @Test
    public void 피연산자n개() {
        assertThat(StringCalculator.calculate("1+2+10")).isEqualTo(13);
        assertThat(StringCalculator.calculate("2/1+3*1000")).isEqualTo(5000);
        assertThat(StringCalculator.calculate("44+11/5*20")).isEqualTo(220);
    }
}