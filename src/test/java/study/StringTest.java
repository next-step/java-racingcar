package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1","2");
    }
}
