import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void 요구사항1() {
        String sut1 = "1,2";
        String sut2 = "1";

        assertThat(sut1.split(",")).contains("1");
        assertThat(sut1.split(",")).contains("2");
        assertThat(sut1.split(",")).contains("1", "2");
        assertThat(sut2.split(",")).containsExactly("1");
    }

    @Test
    void 요구사항2() {
        String sut = "(1,2)";

        String substring = sut.substring(1, sut.length() - 1);

        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt시 문자열 내 위치일 경우 특정 위치의 문자를 가져오고 아닐 경우 예외 발생")
    void 요구사항3() {
        String sut = "abc";

        assertThat(sut.charAt(0)).isEqualTo('a');
        assertThat(sut.charAt(1)).isEqualTo('b');
        assertThat(sut.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> sut.charAt(3))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessage("Index 3 out of bounds for length 3");
    }
}
