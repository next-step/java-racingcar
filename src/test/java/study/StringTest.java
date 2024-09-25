package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void splitTwoNum() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitOneNum() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substringParentheses() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void getCharacterUsingCharAt() {
        String str = "abc";
        char result = str.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    void StringIndexOutOfBoundsExceptionTest() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3"); // String index out of range: 3
    }

}
