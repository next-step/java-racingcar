package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("split-1and2")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split-1")
    void splitOne() {
        String[] array = new String[] {"1"};
        String[] result = "1".split(",");
        assertThat(array[0]).isEqualTo(result[0]);
    }
}
