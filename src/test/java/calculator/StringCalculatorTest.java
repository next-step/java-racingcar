package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void add() {
        // "2 + 3 - 2 * 7 / 3"
        int result = StringCalculator.calculate("2 + 3 - 2 * 7 / 3");
        assertThat(result).isEqualTo(7);
    }
}
