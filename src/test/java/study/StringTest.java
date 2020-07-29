package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1", "2");
    }
}
