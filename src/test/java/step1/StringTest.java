package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitTest() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    void subStringTest() {
        assertEquals("(1,2)".substring(1, 4), "1,2");
    }

    @DisplayName("String-charAt : 특정 문자 가져오기, IndexOutOfBounds 테스트")
    @Test
    void charAtTest() {
        assertEquals("abc".charAt(0), 'a');
        assertEquals("abc".charAt(1), 'b');
        assertEquals("abc".charAt(2), 'c');
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
