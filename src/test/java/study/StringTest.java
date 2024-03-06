package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split 결과가 크기가 2이상인 배열일 경우 반환 확인")
    void splitMulti() {
        String[] result1 = "1,2".split(",");
        assertThat(result1).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split 결과가 크기가 1인 배열인 경우 반환 확인")
    void splitSingle() {
        String[] result1 = "1,2".split(",");
        assertThat(result1).containsExactly("1", "2");
    }


    @Test
    @DisplayName("substring으로 특정 문자 제거하여 반환")
    void substring() {
        String data = "(1,2)";
        int start = data.indexOf("(");
        int end = data.indexOf(")");
        String result = data.substring(start+1, end);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 반환")
    void charAt() {
        String data = "abc";

        assertThatThrownBy(() -> data.charAt(data.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(data.length()));
    }
}