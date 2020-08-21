package pobiStringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void plusTest() {
        int result = StringCalculator.calculate("3 + 1"); //input string output int
        assertThat(result).isEqualTo(4);
    }
}
