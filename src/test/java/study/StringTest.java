package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        // 1-1
        String[] result = "1,2".split(",");
        assertThat(result).contains("2","1");
        assertThat(result).containsExactly("1","2");

        // 1-2
        String[] data = "1".split(",");
        assertThat(data).containsExactly("1");
    }

    @Test
    void subString() {
        // 2
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }
}
