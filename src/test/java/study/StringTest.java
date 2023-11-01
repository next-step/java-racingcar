package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringTest {
    @Test
    public void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    public void split2() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }
}
