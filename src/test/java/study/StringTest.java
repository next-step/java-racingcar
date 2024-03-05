package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {

    @Test
    void testSplit() {
        String[] result = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result).containsExactly("1", "2");
        assertThat(result2).contains("1");
    }

    @Test
    void testSubstring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}