package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Test
    void split() {
        then("1,2".split(",")).containsExactly("1", "2");
        then("1".split(",")).containsExactly("1");
    }

    @Test
    void substring() {
        then("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        then("abc".charAt(0)).isEqualTo('a');
        then("abc".charAt(1)).isEqualTo('b');
        then("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 index를 벗어난 값으로 charAt() 호출시 StringIndexOutOfBoundsException 에러 발생")
    void charAtWithOutOfBoundIdx() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> "abc".charAt(-1));
        assertThrows(StringIndexOutOfBoundsException.class, () -> "abc".charAt(3));
    }
}
