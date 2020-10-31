import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    @DisplayName("문자열 자르기")
    void split () {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 한글자")
    void splitOne () {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("양끝 괄호 삭제")
    void removeBracket () {
        String str = "(1,2)";
        String result = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("해당 위치 글자 출력")
    void printCharIndex () {
        String str = "abc";
        char findChar = str.charAt(1);
        assertThat(findChar).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열 범위 초과 예외")
    void indexOutException () {
        String str = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
