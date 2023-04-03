package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("Test if split() splits string correctly")
    public void testSplitTwoNumbers() {
        var numbers = "1,2".split(",");
        assertThat(numbers).containsExactly("1", "2");
    }

    @Test
    @DisplayName("Test if split() splits string into an array with one element")
    public void testSplitOneNumber() {
        var numbers = "1".split(",");
        assertThat(numbers).containsExactly("1");
    }

    @Test
    @DisplayName("Test parenthesis are removed well")
    public void testRemoveParenthesis() {
        var value = removeParenthesis("(1,2)");
        assertThat(value).isEqualTo("1,2");
    }

    private String removeParenthesis(String value) {
        if (hasParenthesis(value)) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    private boolean hasParenthesis(String value) {
        return value.startsWith("(") && value.endsWith(")");
    }

    @Test
    @DisplayName("Test if charAt() returns element at the right position")
    public void testCharAt() {
        var character = "abc".charAt(2);
        assertThat(character).isEqualTo('c');
    }

    @Test
    @DisplayName("Test if Exception is Thrown When Trying to Get Out of Bound Char")
    public void testCharAtOutOfBound() {
        assertThatThrownBy(() -> "abc".charAt(5))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 5");
    }
}
