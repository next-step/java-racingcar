package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char c = "abc".charAt(0);
        assertThat(c).isEqualTo('a');
    }

    @Test
    @DisplayName("인덱스 벗어나면 에외 발생")
    void charAtException() {
        assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
