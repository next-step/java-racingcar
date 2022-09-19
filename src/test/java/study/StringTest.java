package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1, 2를 ,로 split 했을 때 1과 2를 포함하는 배열을 반환한다.")
    void splitWithOneTwo() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만 포함하는 배열을 반환한다.")
    void splitWithOne() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)가 주어졌을 때 양 끝의 괄호를 제거하고 1,2를 반환한다.")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc값이 주어졌을 때 특정 위치의 문자를 가져온다.")
    void charAt() {
        Character result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치의 문자를 위치 값을 벗어나면 StringIndexOutOfBoundsException가 발생한다")
    void charAtError() {
        assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
