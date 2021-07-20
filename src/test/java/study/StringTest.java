package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result1 = getSplitByComma("1,2");
        assertThat(result1).contains("1").contains("2");

        String[] result2 = getSplitByComma("1");
        assertThat(result2).containsExactly("1");
    }

    private String[] getSplitByComma(String s) {
        return s.split(",");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void getChar() {
        char result;
        result = getCharAt(0);
        assertThat(result).isEqualTo('a');

        result = getCharAt(1);
        assertThat(result).isEqualTo('b');

        result = getCharAt(2);
        assertThat(result).isEqualTo('c');

        assertThatThrownBy(() -> {
            char c = getCharAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range");
    }

    private char getCharAt(int i) {
        return "abc".charAt(i);
    }
}
