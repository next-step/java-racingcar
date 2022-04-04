package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SringTest {
    @Test
    void split() {
        String[] splitNumbers = "1,2".split(",");
        assertThat(splitNumbers).containsExactly("1", "2");
        String[] splitANumber = "1".split(",");
        assertThat(splitNumbers).contains("1");
    }

    @Test
    void substring() {
        String part = "(1,2)".substring(1, 4);
        assertThat(part).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char character = "abc".charAt(0);
        assertThat(character).isEqualTo('a');
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
