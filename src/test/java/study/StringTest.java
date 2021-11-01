package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author han
 */
public class StringTest {

    @Test
    void splitWithComma() {
        String[] oneAndTwo = "1,2".split(",");
        assertThat(oneAndTwo).containsExactly("1", "2");

        String[] one = "1".split(",");
        assertThat(one).contains("1");
    }

    @Test
    void subStringBeforeSpilt() {
        String[] oneAndTwo = "(1,2)".substring(1, 4).split(",");
        assertThat(oneAndTwo).containsExactly("1", "2");
    }

    @Test
    @DisplayName(value = "charAtWithIndexOutOfBoundedException")
    void chatAt() {
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
