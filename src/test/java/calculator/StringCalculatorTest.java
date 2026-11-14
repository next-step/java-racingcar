package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @DisplayName("null 또는 빈문자열 입력 받을 경우 → 0을 리턴한다.")
    @Test
    void test_1() {
        Assertions.assertThat(StringCalculator.calculate("")).isEqualTo(0);
        Assertions.assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    }
}
