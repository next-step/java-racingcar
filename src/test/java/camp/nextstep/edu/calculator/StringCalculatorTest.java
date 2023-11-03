package camp.nextstep.edu.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("null 또는 빈 문자열이 입력되면 0을 반환한다")
    void nullOrEmpty() {
        assertThat(StringCalculator.operate(null)).isEqualTo(0);
        assertThat(StringCalculator.operate("")).isEqualTo(0);
        assertThat(StringCalculator.operate(" ")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 들어오면 그 숫자를 int 형태로 그대로 반환한다")
    void soleNumber() {
        assertThat(StringCalculator.operate("1")).isEqualTo(1);
        assertThat(StringCalculator.operate("999")).isEqualTo(999);
    }
}
