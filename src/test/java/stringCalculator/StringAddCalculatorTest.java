package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null 또는 빈문자면 결과값 0")
    public void splitAndSum_null_또는_빈문자(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("입력 문자열이 숫자 하나면 결과값 숫자")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 문자열에 쉼표구분자만 있으면, 결과값 숫자 합산")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 문자열에 쉼표 또는 콜론 구분자가 있으면, 결과값 숫자 합산")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("입력 문자열에 커스텀 구분자가 있으면, 결과값 숫자 합산")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("입력 문자열에 음수가 있으면, RuntimeException")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력 문자열에 음수 하나만 있으면, RuntimeException")
    public void negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1")).isInstanceOf(RuntimeException.class);
    }
}
