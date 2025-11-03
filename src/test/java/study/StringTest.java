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
    void split2() {
        String[] result = "1".split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String substring = str.substring(1, str.length() - 1);

        assertThat(substring).isEqualTo("1,2");
    }
}
