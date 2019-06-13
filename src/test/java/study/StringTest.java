package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    public void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    public void splitTest2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    public void substringTest() {
        String string = "(1,2)";
        String stringWithNotOutside = string.substring(1, string.length() - 1);
        assertThat(stringWithNotOutside).isEqualTo("1,2");
    }

    @Test
    public void pickCharTest() {
        String string = "abc";
        char b = string.charAt(1);

        assertThat(b).isLowerCase();
        assertThat(b).isEqualTo('b');

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            char c = string.charAt(5);
        });
    }
}
