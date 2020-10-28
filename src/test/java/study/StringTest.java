package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substring() {
        assertThat(stripBracket("(1,2)")).isEqualTo("1,2");
    }

    private String stripBracket(String input) {
        return input.substring(input.indexOf("(") + 1, input.indexOf(")"));
    }
}
