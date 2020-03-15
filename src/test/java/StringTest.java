import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result.length).isEqualTo(2);
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] result = "1".split(",");

        assertThat(result.length).isEqualTo(1);
        assertThat(result[0]).isEqualTo("1");
    }

    @Test
    void substring() {
        String value = "(1,2)";

        String result = value.substring(1, value.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAt() {
        String value = "abc";

        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');

    }

    @Test
    @DisplayName("charAt StringIndexOutOfBoundsException 테스트")
    void charAtException() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
