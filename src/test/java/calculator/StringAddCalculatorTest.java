package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    private StringAddCalculator target = new StringAddCalculator();

    @Test
    @DisplayName("null 또는 빈 문자 주입")
    public void splitAndSum_with_null_or_empty_string() throws Exception {
        int result = target.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = target.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 1개 주입")
    public void splitAndSum_with_one_number() throws Exception {
        int result = target.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자 사용")
    public void splitAndSum_with_comma() throws Exception {
        int result = target.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자 사용")
    public void splitAndSum_with_comma_or_semicolon() throws Exception {
        int result = target.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("custom 구분자 사용")
    public void splitAndSum_with_custom_delimiter() throws Exception {
        int result = target.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("유효하지 않은 delimiter 사용")
    public void test() {
        assertThatThrownBy(() -> target.splitAndSum("!;1;2;3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid delimiter used");
    }

    @Test
    @DisplayName("음수 주입시 에러 발생")
    public void splitAndSum_with_negative__ShouldReturnRuntimeException() {
        assertThatThrownBy(() -> target.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Negative number is not allowed");
    }
}
