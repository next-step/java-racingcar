package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("구분자로 문자열 분리")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 시작과 끝 자르기")
    void substring(){
        String data = "(1,2)";
        int start = 1;
        int end = data.length() - 1;
        String result = data.substring(start, end);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("한 문자 반환")
    @Test
    void charAt() {
        String data = "abc";
        int firstPosition = 0;
        char result = data.charAt(firstPosition);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("문자 반환 범위 초과 오류")
    void charAtOutOfBounds() {
        String data = "abc";
        assertThatThrownBy(() -> data.charAt(data.length()))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
