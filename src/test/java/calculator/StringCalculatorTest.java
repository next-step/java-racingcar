package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    //각각의 단위테스트로 만들어서 pass 하게 만든다
    //그 다음에 다 합치는 방식으로 진행

    @Test
    public void 덧셈() {
        String expression = "1 + 2";

        int result = StringCalculator.calculate(expression.split(" "));
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 곱셈() {
        String expression = "1 * 2";

        int result = StringCalculator.calculate(expression.split(" "));
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 뺄셈() {
        String expression = "1 - 2";

        int result = StringCalculator.calculate(expression.split(" "));
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void 나눗셈() {
        String expression = "1 / 2";

        int result = StringCalculator.calculate(expression.split(" "));
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 계산기() {
        String expression = "1 / 2 + 3 - 2 * 100 - 1";

        int result = StringCalculator.calculate(expression.split(" "));
        assertThat(result).isEqualTo(99);
    }
}