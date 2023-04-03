import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("Test if split() splits the string correctly")
    public void testSplit() {
        var result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("Test if string can be split into single element")
    public void testSingleSplit() {
        var result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    private String removeParenthesis(String str) {
        if (str.length() > 0 && str.charAt(0) == '(') {
            str = str.substring(1, str.length());
        }
        if (str.length() > 0 && str.charAt(str.length() - 1) == ')') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Test
    @DisplayName("Test parenthesis are removed with removeParenthesis()")
    public void testRemovingParenthesis() {
        var result = removeParenthesis("(1,2)");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Test charAt() returns the right char")
    public void testCharAt() {
        var result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("Test if exception is thrown when trying to access out of bound char")
    public void testCharAtOutOfBounds() {
        assertThatThrownBy(() -> "abc".charAt(10))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 10");
    }
}
