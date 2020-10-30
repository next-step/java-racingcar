package secondStage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @DisplayName(value = "문자열을 사칙연산 한다.")
    @Test
    void addAndSubtract() {
        // given
        String source = "2 + 3 * 4 / 2";

        // when
        int result = StringCalculator.calculator(source);

        // then
        assertThat(result).isEqualTo(10);
    }
}