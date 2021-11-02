package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).contains("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("chatAt() 실행 시 string 범위를 넘어갔을 경우 올바른 예외가 나오는지 확인")
    @Test
    void charAt() {
        String str = "abc";
        int index = 3;
        assertThatThrownBy(() -> {str.charAt(index);})
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
