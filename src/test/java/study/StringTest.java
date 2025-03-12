package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

}
