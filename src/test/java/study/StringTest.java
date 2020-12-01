package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    void charAtTest() {
        String result = "abc";
        char character1 = result.charAt(0);
        assertThat(character1).isEqualTo('a');

        char character2 = result.charAt(1);
        assertThat(character2).isEqualTo('b');

        char character3 = result.charAt(2);
        assertThat(character3).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메소드 예외 테스트")
    void charAtExceptionTest() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(5))
                .withMessageMatching("String index out of range: \\d+");
    }
}
