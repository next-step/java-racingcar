package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringUtilTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "122", "32346"})
    void isNumTest(String str) {
        assertThat(StringUtil.isNumber(str)).isEqualTo(true);
    }

    @Test
    void isNumEmptyTest() {
        assertThat(StringUtil.isNumber("")).isEqualTo(false);
    }

    @Test
    void isNumNullTest() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() ->
                    assertThat(StringUtil.isNumber(null)));
    }

    @Test
    void doSplitTest() {
        assertThat(StringUtil.doSplit("a-b-c0d","-")).containsExactly("a","b","c0d");
    }

    @Test
    void doSplitInputNullTest() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() ->
                    StringUtil.doSplit(null," "));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyParameterTest(String str) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() ->
                    StringUtil.doSplit(str,""));
    }

    @Test
    void doSplitSplitKeyWordNullTest() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() ->
                    StringUtil.doSplit("string null test",null));
    }

    @Test
    void doSplitEmptyTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                    StringUtil.doSplit("","dhde"));
    }
}
