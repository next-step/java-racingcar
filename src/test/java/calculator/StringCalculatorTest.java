package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculator("2 + 3 + 4 + 3 + 3 + 3 + 3");
        assertThat(result).isEqualTo(21);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculator("4 - 3 - 3 - 4 - 2 - 4 - 2 - 1 - 2 - 3");
        assertThat(result).isEqualTo(-20);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculator("4 * 3 * 10 * 1 * 3 * 3 * 3 * 3 * 3");
        assertThat(result).isEqualTo(29160);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculator("100 / 5 / 4");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 덧셈_뼬셈_곱셈_나눗셈_무작위_테스트() {
        int result = StringCalculator.calculator("100 / 5 / 4 * 5 * 6 / 2 + 1 + 3 - 20 + 3 + 10 * 2");
        assertThat(result).isEqualTo(144);
    }
}