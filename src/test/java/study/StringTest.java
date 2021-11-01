package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void splitOneCommaTwo() {
        String[] split = "1,2".split(",");

        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void splitOne() {
        String[] split = "1".split(",");

        assertThat(split).containsExactly("1");
    }
}
