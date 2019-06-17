package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @Test
    @DisplayName("문자열이 전부 공백으로만 이루어졌는지 판단하는 기능 검증")
    void isConsistOnlyWhiteSpace() {

        assertThat(StringUtil.isConsistOnlyWhiteSpace("")).isTrue();
        assertThat(StringUtil.isConsistOnlyWhiteSpace(" ")).isTrue();
        assertThat(StringUtil.isConsistOnlyWhiteSpace("     ")).isTrue();

        assertThat(StringUtil.isConsistOnlyWhiteSpace("a")).isFalse();
        assertThat(StringUtil.isConsistOnlyWhiteSpace("1")).isFalse();

        assertThat(StringUtil.isConsistOnlyWhiteSpace(null)).isFalse();
    }
}