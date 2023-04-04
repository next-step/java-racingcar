package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        // 1-1
        String[] result = "1,2".split(",");
        assertThat(result).contains("2","1");
        assertThat(result).containsExactly("1","2");

        // 1-2
        String[] data = "1".split(",");
        assertThat(data).containsExactly("1");
    }

    @Test
    void subString() {
        // 2
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    // 3-3
    @DisplayName("charAt result test")
    void charAtV1() {
        // 3-1
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    // 3-3
    @DisplayName("charAt index out of bounds exception test")
    void charAtV2() {
        // 3-2
        // char data = "abc".charAt(3);
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
