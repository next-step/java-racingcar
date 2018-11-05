package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    @Test
    public void 문자열계산_3반환(){
        int result = StringCalculator.calculate("1 + 2 / 3 * 3");
        assertThat(result).isEqualTo(3);
    }
    @Test
    public void 빈문자열계산_0반환(){
        int result = StringCalculator.calculate(" ");
        assertThat(result).isEqualTo(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void 잘못된연산자_예외반환(){
        StringCalculator.calculate("4 % 2");
    }
}
