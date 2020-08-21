package pobiStringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pobiStringCalculator.StringCalculator.calculate;

public class StringCalculatorTest {
    @Test
    void plusTest() {
        assertThat(calculate("3 + 1")).isEqualTo(4);
    }
    @Test
    void minusTest() {
        assertThat(calculate("3 - 1")).isEqualTo(2);
    }
    @Test
    void multiplyTest() {
        assertThat(calculate("4 * 2")).isEqualTo(8);
    }
    @Test
    void divideTest() {
        assertThat(calculate("4 / 2")).isEqualTo(2);
    }

}
