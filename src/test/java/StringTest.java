import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1, 2를 ,로 나누면 각 숫자는 분리된다.")
    public void split() {
        String input = "1,2";
        assertThat(input.split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 나누면 1만 포함하는 배열이 반환된다.")
    public void splitOneObject() {
        String input = "1";
        assertThat(input.split(",")).contains("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 ( )를 제거하고 1,2만 반환한다.")
    public void splitWithSubString() {
        String input = "(1,2)";
        assertThat(input.substring(1, input.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("주어진 문자열의 특정 위치의 문자를 가져온다.")
    public void charAtTest() {
        String input = "abc";
        int index = 0;
        char expected = 'a';
        assertThat(input.charAt(index)).isEqualTo(expected);
    }

    @Test
    @DisplayName("주어진 문자열의 길이를 넘어 문자를 가져오는 경우 에러를 반환한다.")
    public void charAtExceptionTest() {
        String input = "abc";
        int index = 10;
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
    }
}
