package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");

        result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void substringTest() {
        String subStr = "(1,2)";
        assertThat(subStr.substring(1, subStr.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("displaytest")
    void charAtTest() {
        assertThatThrownBy(()  -> {
            String str = "abc";
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("size:3");
    }
}
