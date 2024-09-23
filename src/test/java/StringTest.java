import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void testSplit() {
        final String targetString = "1,2";
        final String[] split = targetString.split(",");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void testSplit2() {
        final String targetString = "1";
        final String[] split = targetString.split(",");
        assertThat(split).contains("1");
    }

    @Test
    void testSubstring() {
        final String targetString = "(1,2)";
        assertEquals("1,2", targetString.substring(1, 4));
    }

    @Test
    @DisplayName("charAt 메서드의 활용 및 발생 예외 확인")
    void testCharAt() {
        final String targetString = "abc";
        assertEquals('b', targetString.charAt(1));
        assertThrows(StringIndexOutOfBoundsException.class, () -> targetString.charAt(3));
    }
}
