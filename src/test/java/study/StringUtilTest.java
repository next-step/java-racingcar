package study;

import org.junit.jupiter.api.Test;
import step2.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringUtilTest {
    @Test
    void isNumTest() {
        assertThat(StringUtil.isNumber("1")).isEqualTo(true);
    }

    @Test
    void isNumEmptyTest() {
        assertThat(StringUtil.isNumber("")).isEqualTo(false);
    }

    @Test
    void doSplitTest() {
        assertThat(StringUtil.doSplit("a-b-c0d","-")).containsExactly("a","b","c0d");
    }

    @Test
    void doSplitInputNullTest() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> {
                    StringUtil.doSplit(null," ");
                });
    }

    @Test
    void doSplitSplitKeyWordNullTest() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> {
                    StringUtil.doSplit("string null test",null);
                });
    }

    @Test
    void doSplitEmptyTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringUtil.doSplit("","dhde");
                });
    }
}
