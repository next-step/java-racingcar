package cc.oakk.racing.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "\n" })
    @NullSource
    void isEmpty_ShouldReturn_True(String source) {
        assertThat(StringUtil.isEmpty(source)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "hello", "howareyou" })
    void isEmpty_ShouldReturn_False(String source) {
        assertThat(StringUtil.isEmpty(source)).isFalse();
    }

    @Test
    void isLengthGreaterThanOrEqual() {
        assertThat(StringUtil.isLengthGreaterThanOrEqual("abc", 3)).isTrue();
        assertThat(StringUtil.isLengthGreaterThanOrEqual("ab", 3)).isFalse();
        assertThat(StringUtil.isLengthGreaterThanOrEqual("", 3)).isFalse();
        assertThat(StringUtil.isLengthGreaterThanOrEqual("abc", 0)).isTrue();
    }

    @Test
    void split() {
        assertThat(StringUtil.split("a,b,c", ",")).containsExactly("a", "b", "c");
        assertThat(StringUtil.split("a;b", ",")).containsExactly("a;b");
        assertThat(StringUtil.split("a", ",")).containsExactly("a");
    }
}
