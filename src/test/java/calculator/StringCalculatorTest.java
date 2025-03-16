package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void 숫자_하나() {
        assertThat(StringCalculator.toInt("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두 개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void 컴마_구분자() {
        assertThat(StringCalculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자를 콜론 구분자로 입력할 경우 숫자의 합을 반환한다.")
    void 콜론_구분자() {
        assertThat(StringCalculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정하여 구분한 후 숫자들의 합을 반환한다.")
    void 커스텀_구분자() {
        assertThat(StringCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }
}
