package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        String[] results = "1,2".split(",");
        assertThat(results).contains("1");
        assertThat(results).containsExactly("1", "2");
    }
}
