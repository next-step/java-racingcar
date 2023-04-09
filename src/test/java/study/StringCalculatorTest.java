package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 값일 경우 0 반환")
    public void checkNull() {
        int result = StringCalculator.numberStringSum("");
        assertThat(result).isEqualTo(0);

        result = StringCalculator.numberStringSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("하나의 숫자를 문자열로 입력할 경우 해당 숫자 반환")
    public void onlyOneNumberString() {
        int result = StringCalculator.numberStringSum("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 콤마 구분자로 입력할 경우 두 숫자의 합을 반환")
    public void splitAndSum() {
        int result = StringCalculator.numberStringSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론으로도 구분자 사용")
    public void colonDelimiter() {
        int result = StringCalculator.numberStringSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수입력시 RuntimeException 예외발생")
    public void negative() {
        assertThatThrownBy(() -> StringCalculator.numberStringSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("// 와 \n 문자 사이에 커스텀 구분자 사용")
    public void customDelimiter() {
        int result = StringCalculator.numberStringSum("//;\n1;2,3");
        assertThat(result).isEqualTo(6);
    }
}
