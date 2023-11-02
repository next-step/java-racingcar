package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void calculate_null() {
        assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    void calculate_emptyString() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
    }
}
