package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String data = "(1,2)";

        int startIdx = data.indexOf("(");
        int endIdx = data.indexOf(")");
        String result = data.substring(startIdx + 1, endIdx);

        assertThat(result).isEqualTo("1,2");
    }
}
