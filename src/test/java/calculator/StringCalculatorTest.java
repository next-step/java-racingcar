package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void 덧셈_테스트() {
        int result = StringCalculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈_테스트() {
        int result = StringCalculator.calculate("3 - 4");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void 곱셈_테스트() {
        int result = StringCalculator.calculate("3 * 4");
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void 나눗셈_테스트() {
        int result = StringCalculator.calculate("5 / 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 복합_수식_테스트() {
        int result = StringCalculator.calculate("2 + 3 * 4");
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void 수식_문자열_분리_테스트() {
        String[] exprs = StringCalculator.splitExpression("2 + 3 * 4");
        assertThat(exprs).containsExactly("2", "+", "3", "*", "4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지원하지_않는_연산자_테스트() {
        StringCalculator.calculate("2 & 3");
    }

    @Test
    public void 문자열_값_정수_변환_테스트() {
        int result = StringCalculator.parseToNumeric("3");
        assertThat(result).isEqualTo(3);
    }
}