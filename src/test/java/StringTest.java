import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_singleString() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void split_substring() {
        String[] result = "(1,2)".substring(1,4).split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("String.charAt(index) - when index is out of range, throws StringIndexOutOfBoundsException")
    void charAt_StringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> "abc".charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");
    }
}
