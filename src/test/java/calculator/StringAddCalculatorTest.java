package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @Test
    @DisplayName("null과 빈값은 0을 리턴한다")
    void splitAndSum_null_빈값() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("값을 하나 입력하면 그 값이 그대로 리턴된다")
    void splitAndSum_값하나() {
        int result = StringAddCalculator.splitAndSum("2");
        assertThat(result).isEqualTo(2);
    }
}