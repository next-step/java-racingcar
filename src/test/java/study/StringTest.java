package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {
    @Test
    void split() {
        String[] strings = "1,2".split(",");
        assertThat(strings).contains("1");
    }

    @Test
    void splitArray() {
        String[] str = "1,2".split(",");
        assertThat(str).containsExactly("1","2");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);
        assertThat(result).contains("1,2");
    }

    @Test
    void charAt() {
        String string = "abc";
        char c = string.charAt(0);
        assertThat(c).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt 에서 인덱스를 벗어나면 IndexOutOfBoundsException 발생")
    void charAtOutOfBoundsExceptionTest() {
        String string = "abc";
        assertThatThrownBy(() -> string.charAt(5))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching(".*out of range: \\d+.*");
    }


}

