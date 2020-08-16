package cc.oakk.racing.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "\n" })
    @NullSource
    void isEmpty_ShouldReturn_True(String source) {
        assertThat(StringUtils.isEmpty(source)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "hello", "howareyou" })
    void isEmpty_ShouldReturn_False(String source) {
        assertThat(StringUtils.isEmpty(source)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = { "abc,3", "abc,0" })
    void isLengthGreaterThanOrEqual_Should_Return_True(String text, int number) {
        assertThat(StringUtils.isLengthGreaterThanOrEqual(text, number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = { "ab,3", ",0" })
    void isLengthGreaterThanOrEqual_ShouldReturn_False(String text, int number) {
        assertThat(StringUtils.isLengthGreaterThanOrEqual(text, number)).isFalse();
    }

    @Test
    void split() {
        assertThat(StringUtils.split("a,b,c", ",")).containsExactly("a", "b", "c");
        assertThat(StringUtils.split("a;b", ",")).containsExactly("a;b");
        assertThat(StringUtils.split("a", ",")).containsExactly("a");
    }
}
