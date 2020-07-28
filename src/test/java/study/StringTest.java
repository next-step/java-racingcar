package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    private String[] result = "1,2".split(",");

    @Test
    void splitTest1() {

        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    void splitTest2() {

        assertThat(result).containsExactly("1", "2");
    }
}
