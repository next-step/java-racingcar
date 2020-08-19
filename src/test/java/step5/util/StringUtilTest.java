package step5.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    public void emptyTest() {
        String nullValue = null;
        assertThat(StringUtil.isEmpty(nullValue)).isTrue();

        String emptyValue = "";
        assertThat(StringUtil.isEmpty(emptyValue)).isTrue();

        String notEmpty = "abc";
        assertThat(StringUtil.isEmpty(notEmpty)).isFalse();
    }
}
