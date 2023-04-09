package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("빈문자열 또는 null값")
    void 숫자_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);

    }

    @Test
    @DisplayName("빈문자열 또는 null값")
    void 빈문자열_null() {
        assertThat(splitAndSum("")).isEqualTo(0);
    }
}
