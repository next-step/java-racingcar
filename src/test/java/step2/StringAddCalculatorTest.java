package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringAddCalculatorTest {
    // null, 빈문자열 테스트 하는 법
    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullAndEmptySource
    @DisplayName(" 빈 문자열 또는 null 값을 입력할 경우 True 반환")
    void checkNullOrEmpty_ReturnTrue (String input) {
        boolean result = StringAddCalculator.checkNullOrEmpty(input);
        assertThat(result).isTrue();
    }
    @ParameterizedTest
    @ValueSource(strings = {"11", "ee"})
    @DisplayName(" 숫자 문자열 숫자로 반환")
    void checkConvertString_ReturnTypeInteger(String input) {

        assertThatThrownBy(() -> {
            int result = StringAddCalculator.convertStringToInteger(input);
        }).isInstanceOf(NumberFormatException.class)
            .hasMessageContaining("%s: Input string is not number", String.valueOf(input));
    }

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}
