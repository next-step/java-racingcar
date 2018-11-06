package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorStringTest {


    @Test
    public void 문자열계산기() {
        int result = CalculatorString.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 덧셈() {
        int result = CalculatorString.calcu("+", 2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈() {
        int result = CalculatorString.calcu("-", 10, 5);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 곱셈() {
        int result = CalculatorString.calcu("*", 2, 5);
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 나눗셈() {
        int result = CalculatorString.calcu("/", 20, 2);
        assertThat(result).isEqualTo(10);
    }
}