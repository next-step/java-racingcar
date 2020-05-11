package training;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void splitExactly1() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }
}
