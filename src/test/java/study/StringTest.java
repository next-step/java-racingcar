package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void splitTwoNumber() {
        String[] splitStr = "1,2".split(",");
        assertThat(splitStr).containsExactly("1", "2");
    }

    @Test
    public void splitOnlyOneNumber() {
        String[] splitStr = "1".split(",");
        assertThat(splitStr).containsExactly("1");
    }

    @Test
    public void substringRemoveBracket() {
        String inputStr = "(1,2)";
        String resultStr = inputStr.substring(1, inputStr.length() - 1);
        assertThat(resultStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 함수에 문자열 길이 내에 index 입력시")
    public void charAtNormal() {
        char charAt = "abc".charAt(0);
        assertThat(charAt).isEqualTo('a');

        charAt = "abc".charAt(1);
        assertThat(charAt).isEqualTo('b');

        charAt = "abc".charAt(2);
        assertThat(charAt).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 함수에 문자열 길이를 넘어 index 입력시")
    public void charAtOutOfBoundsException() {
        assertThatThrownBy(() -> {
            "abc".charAt(-1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .withMessageMatching("String index out of range: \\d+");
    }
}
