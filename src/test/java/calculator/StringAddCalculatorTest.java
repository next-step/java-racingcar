package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("입력값이 빈 문자열 또는 null일 경우 0 반환")
    void inputIsEmptyOrNull() {
        assertThat(StringAddCalculator.sum("")).isEqualTo(0);
        assertThat(StringAddCalculator.sum(null)).isEqualTo(0);
    }
}
