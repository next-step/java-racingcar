package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).contains("2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }
}
