package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName(value = "String split test")
    void split() throws Exception {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName(value = "String subString test")
    void subString() throws Exception {
        //given
        String input = "(1,2)";

        //when
        int firstBracket = input.indexOf('(');
        int lastBracket = input.indexOf(')');
        String result = input.substring(firstBracket, lastBracket);

        //then
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName(value = "String charAt, IndexOutOfBoundsException test")
    public void charAt() throws Exception {
        //given
        String input = "abc";

        //when
        int index = 3;

        //then
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(index))
                .withMessageMatching("String index out of range: " + index);
    }

}
