import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringSplit {

    @DisplayName("'1,2' 를 구분자 ','로 분리하면 1과 2로 나뉜다.")
    @Test
    void split_1_and_2() {
        String test = "1,2";
        final String[] components = test.split(",");

        assertEquals("1", components[0]);
        assertEquals("2", components[1]);
    }

    @DisplayName("'1'을 구분자 ','로 분리하면 1만 남는다.")
    @Test
    void split_1() {
        String test = "1";
        final String[] components = test.split(",");

        assertThat(components).containsExactly("1");
    }

    @DisplayName("'(1,2)'에서 '()'를 제거하면 '1,2'가 남는다.")
    @Test
    void split_bracket() {
        String test = "(1,2)";
        final String actual = test.substring(1, 4);

        assertEquals("1,2", actual);
    }

    @DisplayName("'a,b,c' 에서 a의 위치는 0번째이다.")
    @Test
    void guess_index_of_character() {
        String test = "a,b,c";
        final char characterA = test.charAt(0);

        assertEquals('a', characterA);
    }

    @DisplayName("'a,b,c' 에서 5번째 문자열을 가져오면 StringIndexOutOfBoundsException 이 발생한다.")
    @Test
    void guess_throw_StringIndexOutOfBoundsException() {
        String test = "a,b,c";

        assertThrows(StringIndexOutOfBoundsException.class, () -> test.charAt(5));
    }
}
