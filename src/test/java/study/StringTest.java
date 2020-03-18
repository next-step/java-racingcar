package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("displaytest")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");

        result = "1".split(",");
        assertThat(result).contains("1");

        String subStr = "(1,2)";
        assertThat(subStr.substring(1, subStr.length()-1)).contains("1,2");


        String str = "abc";
        assertThatThrownBy(()  -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("size:3");
    }
}
