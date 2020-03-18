package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    public void string_test() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
        String[] numberOne = "1".split(",");
        assertThat(numberOne).contains("1");
    }
}
