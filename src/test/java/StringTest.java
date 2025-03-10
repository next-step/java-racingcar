import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {

    @Test
    public void splitStringWithTwoNumber() {
        // given
        String str = "1,2";

        // when
        String[] split = str.split(",");

        // then
        assertThat(split).contains("1", "2");
    }

    @Test
    public void splitStringWithTrailingComma() {
        // given
        String str = "1,";

        // when
        String[] split = str.split(",");

        // then
        assertThat(split).containsExactly("1");
    }

    @Test
    public void substringStringWithParentheses() {
        // given
        String str = "(1,2)";

        // when
        String substring = str.substring(1, str.length() - 1);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메서드를 사용하여 문자열의 문자를 반환한다.")
    @Test
    public void charAtString() {
        // given
        String str = "abc";

        // when
        char charAt = str.charAt(0);

        // then
        assertThat(charAt).isEqualTo('a');
    }

    @DisplayName("charAt() 메서드를 사용하여 문자열의 문자를 반환할 때 범위를 벗어나면 StringIndexOutOfBoundsException 예외가 발생한다.")
    @Test
    public void charAtStringOrThrow() {
        // given
        String str = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy( () -> str.charAt(3)).withMessage("String index out of range: 3");
    }
}
