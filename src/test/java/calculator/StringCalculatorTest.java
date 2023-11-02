package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void calculate_null() {
        assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    void calculate_빈_문자열() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    void calculate_기본_구분자() {
        assertThat(StringCalculator.calculate("1,2")).isEqualTo(3);
        assertThat(StringCalculator.calculate("1,2,3")).isEqualTo(6);
        assertThat(StringCalculator.calculate("1,2:3")).isEqualTo(6);
    }
}
