package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void splitTwoNum() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitOneNum() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

}
