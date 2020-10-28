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
        String string = "(1,2)";
        String result = string.substring(string.indexOf("(") + 1, string.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }
}
