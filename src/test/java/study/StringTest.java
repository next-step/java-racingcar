package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String data = "(1,2)";

        int startIdx = data.indexOf("(");
        int endIdx = data.indexOf(")");
        String result = data.substring(startIdx + 1, endIdx);

        assertThat(result).isEqualTo("1,2");
    }



    @Test
    @DisplayName("String chatAt(): 정상/예외 케이스 테스트")
    void chatAt() {
        String data = "abc";

        // 정상 케이스
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');

        // 예외 케이스
        int findCharAt = 5;
        assertThatThrownBy(() -> data.charAt(findCharAt))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + findCharAt);
    }
}
