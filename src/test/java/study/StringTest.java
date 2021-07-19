package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("요구사항 1_1")
    @Test
    void split1() {

        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항 1_2")
    @Test
    void split2() {

        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void substring() {

        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3_1")
    void charAt1() {

        char result = "abc".charAt(2);
        assertThat(result).isEqualTo('c');

    }

    @Test
    @DisplayName("요구사항 3_2")
    void charAt2() {

        String str = "abc";
        int strSize = str.length();
        int index = 3;

        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + strSize);
    }
}
