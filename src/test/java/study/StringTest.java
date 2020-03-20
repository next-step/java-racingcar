package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    String formula = "2 + 3 * 4 / 2";

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String value2 = value.substring(1, 4);
        String[] result = value2.split(",");
        assertThat(result).containsExactly("1", "2");
    }
}
