import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void 요구사항1() {
        String[] sut1 = "1,2".split(",");
        String[] sut2 = "1".split(",");

        assertThat(sut1).contains("1");
        assertThat(sut1).contains("2");
        assertThat(sut1).contains("1", "2");
        assertThat(sut2).containsExactly("1");
    }

    @Test
    void 요구사항2() {
        String str = "(1,2)";

        String sut = str.substring(1, str.length() - 1);

        assertThat(sut).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt시 문자열 내 위치일 경우 특정 위치의 문자를 가져오고 아닐 경우 예외 발생")
    void 요구사항3() {
        String str = "abc";

        char sut1 = str.charAt(0);
        char sut2 = str.charAt(1);
        char sut3 = str.charAt(2);

        assertThat(sut1).isEqualTo('a');
        assertThat(sut2).isEqualTo('b');
        assertThat(sut3).isEqualTo('c');

        assertThatThrownBy(() -> {
            char sut4 = str.charAt(3);
        })
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessage("Index 3 out of bounds for length 3");
    }
}
