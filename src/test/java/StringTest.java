import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("Split numbers and verify if 1,2 returns")
    void SplitCheckTestWithOneTwo() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }
    @Test
    @DisplayName("Split numbers and verify if 1 returns")
    void SplitCheckTestWithOne() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("Substring if there's Parenthesis exists")
    void SubstringRemovalParenthesis() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);

        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("Get index of specific string character")
    void GetStringIndex() {
        String input = "abc";
        char result = input.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("Get index of specific string character but throw exception")
    void GetStringIndexWithException() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
