package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
        
        result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void replaceBracketToEmptySpace() {
        String input = "(1,2)";

        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }
}
