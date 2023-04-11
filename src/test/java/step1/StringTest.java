package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 테스트")
    public void splitTest() {
        String str1 = "1,2";
        String str2 = "1";
        assertThat(str1.split(",")).containsExactly("1", "2");
        assertThat(str2.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring 테스트")
    public void substringTest() {
        String str = "(1,2)";
        assertThat(str.substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt과 Exception 테스트")
    public void charAtAndExceptionTest() {
        String str = "abc";
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> {
            str.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 4");
    }
}
