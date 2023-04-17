package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @NullAndEmptySource
    public void checkNull(String checkStr) {
        int result = stringCalculator.numberStringSum(checkStr);
        assertThat(result).isEqualTo(0);

        result = stringCalculator.numberStringSum(checkStr);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("하나의 숫자를 문자열로 입력할 경우 해당 숫자 반환")
    public void onlyOneNumberString() {
        int result = stringCalculator.numberStringSum("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 콤마 구분자로 입력할 경우 두 숫자의 합을 반환")
    public void splitAndSum() {
        int result = stringCalculator.numberStringSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론으로도 구분자 사용")
    public void colonDelimiter() {
        int result = stringCalculator.numberStringSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수입력시 RuntimeException 예외발생")
    public void negative() {
        assertThatThrownBy(() -> stringCalculator.numberStringSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("// 와 \n 문자 사이에 커스텀 구분자 사용")
    public void customDelimiter() {
        int result = stringCalculator.numberStringSum("//;\n1;2,3");
        assertThat(result).isEqualTo(6);
    }
}
