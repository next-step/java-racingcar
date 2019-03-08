package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void name() {
        int result = StringCalculator.calculator("1 + 2");
        assertThat(result).isEqualTo(3);

    }
}