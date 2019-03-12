package calculator;

import calculator.service.CalculatorCore;
import calculator.service.CalculatorView;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    public void 덧셈() {
        int result = CalculatorCore.calculate("+", "3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 곱셈() {
        int result = CalculatorCore.calculate("*", "3");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 뺄셈() {
        int result = CalculatorCore.calculate("-", "3");
        assertThat(result).isEqualTo(-3);
    }

    @Test
    public void 나눗셈() {
        int result = CalculatorCore.calculate("/", "3");
        assertThat(result).isEqualTo(0);
    }

    @Test(expected = RuntimeException.class)
    public void 나눗셈에러() {
        int result = CalculatorCore.calculate("/", "0");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 복합연산() {
        String[] input = {"2", "+", "3", "*", "4", "/", "2"};
        int result = CalculatorCore.createExpression(input);
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 여러자리수_복합연산() {
        String[] input = {"200", "+", "30", "/", "10", "-", "3"};
        int result = CalculatorCore.createExpression(input);
        assertThat(result).isEqualTo(20);
    }

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