import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    public void returnZeroFromBlankAndNullValue() {
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
    }


}