package calculator;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculate("2 - 1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculate("1 * 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculate("2 / 1");
        assertThat(result).isEqualTo(2);
    }

}
