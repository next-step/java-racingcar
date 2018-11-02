package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    @Test
    public void 덧셈() {
      int result = StringCalculator.calculate("3 + 3");
      assertThat(result).isEqualTo(6);
    }
    @Test
    public void 뺄셈(){
        int result = StringCalculator.calculate("3 - 3");
        assertThat(result).isEqualTo(0);

    }
    @Test
    public void 나눗셈(){
        int result = StringCalculator.calculate("5 / 1");
        assertThat(result).isEqualTo(5);
    }
    @Test
    public void 곱셈(){
        int result = StringCalculator.calculate("2 * 2");
        assertThat(result).isEqualTo(4);
    }
}
