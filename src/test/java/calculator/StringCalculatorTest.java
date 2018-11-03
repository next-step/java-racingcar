package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺠셈() {
        int result = StringCalculator.calculate("3 - 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculate("2 * 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculate("4 / 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 누적연산() {
        assertThat(StringCalculator.calculate("2 + 3 * 4")).isEqualTo(20);
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2 + 2")).isEqualTo(12);
    }
}