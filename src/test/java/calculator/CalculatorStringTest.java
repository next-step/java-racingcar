package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorStringTest {




    @Test
    public void 덧셈() {
        int result = CalculatorString.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈() {
        int result = CalculatorString.calculate("2 - 3");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void 곱셈() {
        int result = CalculatorString.calculate("2 * 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 나눗셈() {
        int result = CalculatorString.calculate("10 / 2");
        assertThat(result).isEqualTo(5);
    }
}