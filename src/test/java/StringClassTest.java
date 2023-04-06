import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringClassTest {

    @Test
    @DisplayName(" \"1,2\" 문자열은 ',' 구분자로 분리되어야 한다.")
    void split_01() {
        final String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName(" \"1는 ','로 분리 했을 시, \"1\"만 반환해야 한다.")
    void split_02() {
        String word = "1";

        String[] result = word.split(",");

        assertThat(result).containsExactly("1");
        assertEquals(1, result.length);
    }

    @Test
    @DisplayName("substring()을 통한 () 제거")
    void substring() {
        String word = "(1,2)";

        String result = word.substring(1, word.length() - 1);

        assertEquals("1,2", result);
    }

    @Test
    @DisplayName("charAt()을 통해 특정 위치 문자를 가져올 수 있다.")
    void charAt_success() {
        String word = "abc";

        char a = word.charAt(0);
        char b = word.charAt(1);
        char c = word.charAt(2);

        assertEquals('a', a);
        assertEquals('b', b);
        assertEquals('c', c);
    }

    @Test
    @DisplayName("charAt()가 인덱스를 벗어나면 예외를 던진다.")
    void charAt_fail() {
        String word = "abc";

        assertThrows(StringIndexOutOfBoundsException.class, () -> word.charAt(4));
    }
}
