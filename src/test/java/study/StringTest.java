package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split_by_comma() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }
    @Test
    void split() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring_test() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
    }


}
