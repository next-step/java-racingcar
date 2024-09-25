package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @DisplayName("'1,2'를 ','기준으로 split 했을 때 1과 2로 분리된다. ")
    @Test
    void splitAndContainsExactlyTest() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("'1'을 ',' 기준으로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    @Test
    void splitAndContainsTest() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @DisplayName("substring 을 활용해 괄호를 제거한 문자열을 반환한다.")
    @Test
    void substringTest() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    @Test
    void charAtTest() {
        char c = "abc".charAt(2);
        assertThat(c).isEqualTo('c');
    }

    @DisplayName("위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
    @Test
    void stringIndexOutOfBoundsExceptionTest() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(str.length() + 1))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + (str.length() + 1));
    }
}
