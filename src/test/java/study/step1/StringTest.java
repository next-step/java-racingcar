package study.step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void 요구사항1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    public void 요구사항2() {
        String input = "(1,2)";
        String actual = removeParenthesis(input);
        String expected = "1,2";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 요구사항3() {
        String input = "abc";
        char expected = 'b';

        assertThat(getCharByIndex(input, 1)).isEqualTo(expected);

        assertThatThrownBy(() -> getCharByIndex(input, input.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + input.length());

    }

    private char getCharByIndex(String someString, int index) throws IndexOutOfBoundsException {
        return someString.charAt(index);
    }

    private String removeParenthesis(String someString) {
        if (hasParenthesis(someString))
            return someString.substring(1, someString.length() - 1);
        return someString;
    }

    private boolean hasParenthesis(String someString) {
        return someString.startsWith("(") && someString.endsWith(")");
    }
}


