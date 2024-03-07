package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("요구사항 1")
    public void split() {
        String[] values = "1".split(",");
        Assertions.assertThat(values).contains("1");
        values = "1,2".split(",");
        Assertions.assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 2")
    public void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        Assertions.assertThat(result).isEqualTo("1,2");

    }
}
