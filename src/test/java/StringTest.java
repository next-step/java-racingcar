import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    @Test
    void request1_1() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    void request1_2() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void request2() {
        final String str3 = "(1,2)";
        assertThat(str3.substring(1, str3.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
    void request3_1() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    void request3_2() {
        final String str = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(str.length());
                }).withMessageMatching("String index out of range: 3");
    }
}
