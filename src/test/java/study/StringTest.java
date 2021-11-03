package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("split method test")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("substring method test")
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }
}
