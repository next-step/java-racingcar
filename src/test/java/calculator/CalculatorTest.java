package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

//    @Test
//    public void 덧셈() {
//        int result = CalculatorCore.calculate("+", "3");
//        assertThat(result).isEqualTo(5);
//    }
//
//    @Test
//    public void 곱셈() {
//        int result = CalculatorCore.calculate("5 * 4");
//        assertThat(result).isEqualTo(20);
//    }
//
//    @Test
//    public void 뺄셈() {
//        int result = CalculatorCore.calculate("5 - 4");
//        assertThat(result).isEqualTo(1);
//    }
//
//    @Test
//    public void 나눗셈() {
//        int result = CalculatorCore.calculate("10 / 2");
//        assertThat(result).isEqualTo(5);
//    }
//
//    @Test
//    public void 복합연산() {
//        int result = CalculatorCore.calculate("2 + 3 * 4 / 2");
//        assertThat(result).isEqualTo(10);
//    }
//
//    @Test
//    public void 복합연산2() {
//        int result = CalculatorCore.calculate("2 + 3 * 4 * 2 * 10");
//        assertThat(result).isEqualTo(400);
//    }

    @Test
    public void 정규식() {
        boolean result = CalculatorView.patternMatcher("2 + 3");
        assertThat(result).isTrue();
        result = CalculatorView.patternMatcher("2 + 3 * 4 / 2");
        assertThat(result).isTrue();
        result = CalculatorView.patternMatcher("2 + 30 * 4 / 2");
        assertThat(result).isTrue();
        result = CalculatorView.patternMatcher("200 + 3 * 4 + 20");
        assertThat(result).isTrue();


    }

    @Test(expected = RuntimeException.class)
    public void 정규식에러() {
        boolean result = CalculatorView.patternMatcher("2 +3 * 4 / 2");
        assertThat(result).isFalse();
        result = CalculatorView.patternMatcher("2 + 3 * 4 / ");
        assertThat(result).isFalse();
        result = CalculatorView.patternMatcher(" + 3 * 4 / 2");
        assertThat(result).isFalse();
    }

}