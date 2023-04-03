package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt() 메소드 성공")
    void chatAt_Success() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("chatAt() 메소드 IndexOutOfBoundsException 발생")
    void charAt_IndexOutOfBoundsException() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
