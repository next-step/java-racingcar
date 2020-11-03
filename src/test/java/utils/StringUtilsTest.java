package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    void isEmpty() {
        assertThat(StringUtils.isEmpty(null)).isTrue();
        assertThat(StringUtils.isEmpty("")).isTrue();
        assertThat(StringUtils.isEmpty(" ")).isTrue();
        assertThat(StringUtils.isEmpty("test")).isFalse();
    }

    @Test
    public void testRepeat() {
        assertThat(StringUtils.repeat("*", 3)).isEqualTo("***");
    }
}