import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringClassTest {
    private static final String COMMA_DELIMITER = ",";

    @Test
    @DisplayName("1,2를 쉼표(,)로 분리했을 때")
    void splitTest1() {
        String str = "1,2";
        assertThat(str.split(COMMA_DELIMITER)).contains("1", "2");
    }

    @Test
    @DisplayName("1을 쉼표(,)로 분리했을 때")
    void splitTest2() {
        String str = "1";
        assertThat(str.split(COMMA_DELIMITER)).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)에서 괄호 제거하기")
    void substringTest() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 올바른 인덱스를 입력했을 때")
    void charAtTestNormal() {
        String abc = "abc";
        assertThat(abc.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 인덱스를 벗어났을 때")
    void charAtTestError() {
        String abc = "abc";
        assertThatThrownBy(() -> abc.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
