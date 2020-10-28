package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("기본 문자열 스플릿 테스트")
    public void splitTest() {
        final String input = "1,2";
        final String[] strings = input.split(",");

        assertThat(strings).containsExactly("1", "2");
    }

    @Test
    @DisplayName("구분자가 없는 문자열 스플릿 테스트")
    public void splitTestHasNoDelimiter() {
        final String input = "1";
        final String[] strings = input.split(",");

        assertThat(strings).containsExactly("1");
    }

    @Test
    @DisplayName("subString 테스트")
    public void subStringTest() {
        String input = "(1,2)";
        input = input.substring(1, input.length() - 1);

        assertThat(input).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    public void charAtTest() {
        final String input = "abc";
        final char a = input.charAt(0);

        assertThat(a).isEqualTo('a');
    }

    @Test
    @DisplayName("인덱스 범위 밖 charAt 테스트")
    public void charAtExceptionTest() {
        final String input = "abc";

        assertThatThrownBy(() -> input.charAt(3))
                .isExactlyInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");
    }
}
