package pobiStringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pobiStringCalculator.StringCalculator.calculate;

public class StringCalculatorTest {
    @Test
    void plusTest() {
        // int result = calculate("3 + 1"); input string output int, static import l
        assertThat(calculate("3 + 1")).isEqualTo(4);
    }
}
