package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @DisplayName("문자열 \"1,2\" split")
    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("문자열 \"1\" split 하였을 때 배열로 출력")
    @Test
    void split1() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("문자열 substring 으로 괄호 제거")
    @Test
    void substring() {
        String s = "(1,2)";
        int open = s.indexOf("(");
        int close = s.indexOf(")");

        String result = s.substring(open + 1, close);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("문자열 charAt 으로 특정위치 가져올 때, 위치 값 벗어나는 값 조회 에러")
    @Test
    void charAt() {
        String s = "abc";
        assertThatThrownBy(() -> s.charAt(5)).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 5");
    }
}