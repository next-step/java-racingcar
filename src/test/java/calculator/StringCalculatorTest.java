package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    @Test
    public void 덧샘() {
        int result = StringCalculator.calculator("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄샘() {
        int result = StringCalculator.calculator("3 - 1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱샘() {
        int result = StringCalculator.calculator("3 * 2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 나눗샘() {
        int result = StringCalculator.calculator("6 / 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 복합_연산() {
        int result = StringCalculator.calculator("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}