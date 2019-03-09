package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
        System.out.println("setUp");
    }

    @Test
    public void 덧셈() {
        int result = stringCalculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 곱셈() {
        int result = stringCalculator.calculate("5 * 4");
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void 뺄셈() {
        int result = stringCalculator.calculate("5 - 4");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 나눗셈() {
        int result = stringCalculator.calculate("10 / 2");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 복합연산() {
        int result = stringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 정규식() {
        boolean result = stringCalculator.patternMatcher("2 + 3");
        assertThat(result).isTrue();
        result = stringCalculator.patternMatcher("2 + 3 * 4 / 2");
        assertThat(result).isTrue();
        result = stringCalculator.patternMatcher("2 +3 * 4 / 2");
        assertThat(result).isFalse();
        result = stringCalculator.patternMatcher("2 + 3 * 4 / ");
        assertThat(result).isFalse();
        result = stringCalculator.patternMatcher(" + 3 * 4 / 2");
        assertThat(result).isFalse();
    }

}