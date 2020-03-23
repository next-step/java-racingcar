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
    }

    @Test
    void substring() {
        String value = "(1,2)";

        String result = "(1,2)".substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("chatAt()의 index 범위를 벗어나는 경우")
    void charAtThrowException() {
        String value = "abc";

        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
