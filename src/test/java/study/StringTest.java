package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }
    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }
    @Test
    void split3() {
        String str = "(1,2)";
        String result = str.substring(1, str.length()-1);
        assertThat(result).isEqualTo("1,2");
    }
}
