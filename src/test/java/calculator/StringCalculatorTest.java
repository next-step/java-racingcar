package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculator("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculator("4 - 3");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculator("4 * 3");
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculator("10 / 5");
        assertThat(result).isEqualTo(2);
    }

}