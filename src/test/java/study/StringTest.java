package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2를 1과 2로 잘 분리되는지 확인")
    void split() {
        String[] actual = "1,2".split(",");

        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1,를 1만 포함하는 배열로 분리되는지 확인")
    void splitOneValue() {
        String[] actual = "1,".split(",");

        assertThat(actual).contains("1");
    }

    @Test
    @DisplayName("(1, 2)를 괄호 제거 후 1과 2로 분리되는지 확인")
    void subStringTest() {
        String str = "(1,2)";
        String actual = str.substring(1, str.length() - 1);

        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc에서 charAt()으로 특정 위치의 문자를 가져오는지 확인")
    void charAtTest() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt()에서 위치 값을 벗어날 때 예외처리 확인")
    void charAtIndexOutOfBoundException() {
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + str.length());
    }
}
