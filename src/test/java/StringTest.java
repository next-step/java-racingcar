import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    @DisplayName("숫자로 컴마로 이루어진 문자열을 입력받아 컴마로 숫자를 분리해서 정수 배열을 반환해야 한다.")
    void testSeparateByComma() {
        String input = "1,2,3";

        String[] result = input.split(",");

        assertThat(result).contains("1", "2", "3");
    }

    @Test
    @DisplayName("괄호로 감싸진 문자열을 입력받아 괄호가 제거된 문자열을 반환해야 한다.")
    void testExtractStringFromBracket() {
        String input = "(1,2,3)";

        String result = input.substring(1, input.length() - 1);

        assertEquals("1,2,3", result);
    }

    @Test
    @DisplayName("문자열의 특정 위치를 입력받아 그 위치에 해당하는 문자를 반환해야 한다.")
    void testGetCharacterAtIndex() {
        String input = "abc";

        assertEquals('c', input.charAt(2));
        assertThatThrownBy(() -> input.charAt(-1))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");
    }
}
