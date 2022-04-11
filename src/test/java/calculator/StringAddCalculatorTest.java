package calculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null값을_입력했을때(String str) {
        assertTrue(Strings.isNullOrEmpty(str));
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    void custom_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수_기본구분자() {
        assertThatThrownBy(()-> {
            StringAddCalculator.splitAndSum("-1:2,3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_커스텀구분자() {
        assertThatThrownBy(()-> {
            StringAddCalculator.splitAndSum("//;\n-1;2;3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}