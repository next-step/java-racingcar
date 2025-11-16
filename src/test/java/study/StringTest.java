package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName(",로 split 했을 때 배열로 분리된다")
    void splitWithTwoElements() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName(",로 split 했을 때 1만 포함하는 배열이 반환된다")
    void splitWithOneElement() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring()로 1,2를 반환한다")
    void substring() {
        String input = "(1,2)";

        String substring = input.substring(1, input.length() - 1);

        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()로 특정 위치의 문자를 반환한다")
    void charAt() {
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() 인덱스 범위를 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    void charAtException() {
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
