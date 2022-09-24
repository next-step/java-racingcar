package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("null 또는 빈문자일때 0 리턴")
    public void splitAndSum_null_or_empty() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }


    @Test
    @DisplayName("숫자 하나일 때")
    public void splitAndSum_one_number() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("콤마 구분자")
    public void splitAndSum_comma_separator() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마 OR 콜론 구분자")
    public void splitAndSum_comma_or_colon_separator() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자(;)")
    public void splitAndSum_custom_separator() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 에러")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
