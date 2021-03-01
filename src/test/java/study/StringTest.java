package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void splitTest() {
        String[] data = "1,2".split(",");
        //assertThat(data).contains("1");
        assertThat(data).containsExactly("1","3");
    }
}
