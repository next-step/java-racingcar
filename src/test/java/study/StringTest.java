package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void 요구사항1_split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void 요구사항2_split() {
        String data = "(1,2)";
        String result = data.substring(1, data.length()-1);
        assertThat("1,2").isEqualTo(result);
    }
}
