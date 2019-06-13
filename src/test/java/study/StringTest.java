package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {
    @Test
    void splitTest() {
        String input = "1,2";
        assertThat(input.split(",")).containsExactly("1", "2");
    }

    @Test
    void splitTest2() {
        String input = "1";
        assertThat(input.split(",")).containsExactly("1");
    }

    @Test
    void substringTest() {
        String input = "(1,2)";
        assertThat(input.substring(1,4)).isEqualTo("1,2");
    }

    @Test
    void charAtTest() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    void charAtTest2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                });
    }
}
