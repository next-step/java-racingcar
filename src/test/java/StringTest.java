import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    public void split() {
        String[] results;
        results = "1,2".split(",");
        assertThat(results).containsExactly("1", "2");

        results = "1".split(",");
        assertThat(results).contains("1");
    }

    @Test
    public void substring() {
        final String source = "(1,2)";
        String result = source.substring(1, source.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("test for `String.charAt` using valid/invalid indexes ")
    public void charAt() {
        final String source = "abc";
        char result = source.charAt(1);
        assertThat(result).isEqualTo('b');

        assertThatThrownBy(() -> {
            source.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 3");
    }
}