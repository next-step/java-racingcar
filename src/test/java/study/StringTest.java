package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split_comma_with_two_items() {
        String data = "1,2";
        String[] result = data.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1" ,"2");
    }

    @Test
    void split_comma_with_one_item() {
        String data = "1";
        String[] result = data.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring_parentheses_with_two_items() {
        String data = "(1,2)";
        String result = data.substring(1, 4);
        assertThat(result).contains("1,2");
        assertThat(result).doesNotContain("(", ")");
    }
}
