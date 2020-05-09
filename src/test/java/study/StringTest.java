package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String split 테스트")
    void splitTest() {
        String[] value = "1,2".split(",");
        assertThat(value).containsExactly("1", "2");

        value = "1".split(",");
        assertThat(value).contains("1");
    }

    @Test
    @DisplayName("String substring 테스트")
    void substringTest() {
        String value = "(1,2)";
        value = value.substring(1, value.length() - 1);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt 테스트")
    void charAtTest() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("String charAt assertThatThrownBy 테스트")
    void charAtIndexOutOfBoundsExceptionTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 3");
    }

    @Test
    @DisplayName("String charAt assertThatExceptionOfType 테스트")
    void charAtAssertThatExceptionOfTypeTest() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                }).withMessageContaining("index out of range: 3");
    }
}