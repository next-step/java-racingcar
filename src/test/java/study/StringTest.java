package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("split string made of two items by comma(,)")
    void split_comma_with_two_items() {
        String data = "1,2";
        String[] result = data.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1" ,"2");
    }

    @Test
    @DisplayName("split string made of one item by comma(,)")
    void split_comma_with_one_item() {
        String data = "1";
        String[] result = data.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring string without parentheses ")
    void substring_parentheses_with_two_items() {
        String data = "(1,2)";
        String result = data.substring(1, 4);
        assertThat(result).contains("1,2");
        assertThat(result).doesNotContain("(", ")");
    }

    @Test
    @DisplayName("get a character with index using charAt")
    void get_character_of_index_with_charAt() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("test for charAt method on IndexOutOfBoundsException and assertThatThrownBy")
    void get_character_of_index_with_charAt_and_assertThatThrownBy() {
        assertThatThrownBy(() -> {
            String data = "abc";
            data.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3")
                .hasMessageContaining("range: 3")
                .hasMessageStartingWith("String index")
                .hasMessageEndingWith(": 3");
    }

    @Test
    @DisplayName("test for charAt method on IndexOutOfBoundsException and assertThatExceptionOfType")
    void get_character_of_index_with_charAt_assertThatExceptionOfType() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
            String data = "abc";
            data.charAt(3);
        }).withMessageMatching("String index out of range: \\d+")
                .withMessage("String index out of range: 3")
                .withMessageContaining("range: 3")
                .withMessageStartingWith("String index")
                .withMessageEndingWith(": 3");
    }
}
