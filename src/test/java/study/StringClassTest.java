package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringClassTest {
    @Test
    void splitIntoArray() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitIntoSingleElementArray() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }
}
