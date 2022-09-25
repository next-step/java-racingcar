package step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {
    @ParameterizedTest(name="splitAndSum_null_또는_빈문자")
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String str) {
        int result = StringAddCalculator.splitAndSum(str);
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

    @ParameterizedTest(name="{index} splitAndSum_음수_숫자없는_문자열 {arguments}")
    @ValueSource(strings = {"-1,2:3", "hello world", "\\@\n-1@2@3"})
    public void splitAndSum_invalid_input(String str) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(str)).isInstanceOf(RuntimeException.class);
    }
}
