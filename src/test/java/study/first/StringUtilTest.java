package study.first;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    private Calculator calculator = new Calculator();

    @DisplayName("empty test")
    @Test
    void emptyTest() {
        assertThat(StringUtils.isEmpty(" ")).isTrue();
        assertThat(StringUtils.isEmpty("")).isTrue();
        assertThat(StringUtils.isEmpty(null)).isTrue();
        assertThat(StringUtils.isEmpty("                   ")).isTrue();
        assertThat(StringUtils.isEmpty("1")).isFalse();
    }

    @DisplayName("is not empty test")
    @Test
    void isNotEmptyTest() {
        assertThat(StringUtils.isNotEmpty(" 1")).isTrue();
        assertThat(StringUtils.isNotEmpty("               1     ")).isTrue();
        assertThat(StringUtils.isNotEmpty("       1   1   ")).isTrue();
        assertThat(StringUtils.isNotEmpty("1")).isTrue();
        assertThat(StringUtils.isNotEmpty("")).isFalse();
    }

    @DisplayName("even number input test")
    @Test
    void wrongInputTest1() {
        assertThat(StringUtils.isEvenInputLength(3)).isFalse();
        assertThat(StringUtils.isEvenInputLength(2)).isTrue();
    }
}
