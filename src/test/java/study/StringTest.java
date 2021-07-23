package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void 문자열_구분자_쉼표로_분리() {
        String first = "1,2";
        String[] splitedFirst = first.split(",");
        assertThat(splitedFirst).contains("1", "2");

        String second = "1";
        String[] splitedSecond = second.split(",");
        assertThat(splitedSecond).containsExactly("1");
    }

    @Test
    void 특정위치의_문자_제거() {
        String givenString = "(1,2)";
        String expectedString = "1,2";
        assertThat(givenString.substring(1, 4)).isEqualTo(expectedString);
    }

    @Test
    @DisplayName("위치값_벗어난_문자_가져올때_오류발생")
    void StringIndexOutOfBoundsExceptionTest() {
        String givenString = "abc";

        assertThatThrownBy(() -> givenString.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");

    }
}
