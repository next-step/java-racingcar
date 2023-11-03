package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    void 빈문자열_null() {
        assertThat(StringCalculator.cal("")).isEqualTo(0);
        assertThat(StringCalculator.cal(null)).isEqualTo(0);
    }
}
