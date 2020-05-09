package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void splitSingle() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void subString() {
        String source = "(1,2)";
        String result = source.substring(1, source.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }
}
