package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("'1,2'를 ','로 split하면 '1''2'를 반환")
    void splitSeveralElements() {
        assertSplit("1,2", Arrays.array("1", "2"), ",");
    }

    @Test
    @DisplayName("'1'을 ','로 split하면 '1'을 반환")
    void splitOneElement() {
        assertSplit("1", Arrays.array("1"), ",");
    }

    @Test
    @DisplayName("'(1,2)'에서 괄호를 제거하면 '1,2'를 반환")
    void subString() {
        String input = "(1,2)";
        String substring = input.substring(1, 4);
        assertEquals("1,2", substring);
    }

    @Test
    @DisplayName("'abc'에서 각 인덱스 문자를 반환")
    void chartAt() {
        assertChartAt("abc", 'a', 0);
        assertChartAt("abc", 'b', 1);
        assertChartAt("abc", 'c', 2);
    }

    @Test
    @DisplayName("문자열 인덱스를 벗어나면 StringIndexOutOfBoundsException 발생")
    void charAtOutOfBounds() {
        assertThatThrownBy(() -> {
            assertChartAt("abc",'a',4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    private void assertSplit(String input, String[] expStr, String delimiter) {
        String[] splits = input.split(delimiter);
        assertThat(splits).containsExactly(expStr);
    }

    private void assertChartAt(String input, char expChar, int index) {
        char charAt = input.charAt(index);
        assertEquals(expChar, charAt);
    }
}
