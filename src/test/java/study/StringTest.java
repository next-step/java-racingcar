package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String value = "(1,2)";

        String result = "(1,2)".substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }
}
