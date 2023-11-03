package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    void 빈문자열_null() {
        assertThat(StringCalculator.cal("")).isEqualTo(0);
        assertThat(StringCalculator.cal(null)).isEqualTo(0);
    }

    @Test
    void 숫자하나문자열() {
        assertThat(StringCalculator.cal("1")).isEqualTo(1);
        assertThat(StringCalculator.cal("2")).isEqualTo(2);
    }

    @Test
    void 숫자두개_컴마구분자_문자열() {
        assertThat(StringCalculator.cal("1,2")).isEqualTo(3);
        assertThat(StringCalculator.cal("2,3")).isEqualTo(5);
    }
}
