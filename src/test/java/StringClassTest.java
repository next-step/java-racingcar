import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {

    final int BUFFER = 1;

    @DisplayName("1,2를 분리")
    @Test
    void 문자열분리_1() {
        String input = "1,2";
        assertThat(input.split(",")).containsExactly("1", "2");
    }

    @DisplayName("1을 분리")
    @Test
    void 문자열분리_2() {
        String input = "1";
        assertThat(input.split(",")).containsExactly("1");
    }

    @DisplayName("(1,2) 주어지면 `1,2`")
    @Test
    void 문자열분리_3() {
        String input = "(1,2)";
        assertThat(input.substring(BUFFER, input.length() - BUFFER)).contains("1,2");
    }

    @DisplayName("abc주어지면 charAt() 사용하여 특정 위치 문자 가져오기")
    @Test
    void string3_1() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
    }

    @DisplayName("abc주어지면 charAt() 사용하여 특정 위치 문자 가져오기")
    @Test
    void string3_Throw() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
