import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitWithComma(){
        String test = "1,2";
        String[] result = test.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");

        assertThat(result).containsExactly("1", "2");
//        assertThat(result).containsExactly("2", "1");
    }

    @Test
    void splitWithoutComma(){
        String test = "1";
        String expected = "1";

        String[] result = test.split(",");
        assertThat(result).contains(expected);
        assertThat(result).hasSize(1);
    }

    @Test
    void substring() {
        String test = "(1,2)";
        String expected = "1,2";

        String result = test.substring(1, 4);
        assertThat(result).isEqualTo(expected);
    }

    @Nested
    @DisplayName("charAt 테스트")
    class testCharAt {
        @Test
        @DisplayName("특정 위치 문자 가져오기")
        void charAt() {
            String test = "abc";
            char a = test.charAt(0);
            char b = test.charAt(1);
            char c = test.charAt(2);

            assertThat(a).isEqualTo('a');
            assertThat(b).isEqualTo('b');
            assertThat(c).isEqualTo('c');
        }

        @Test
        @DisplayName("범위 초과 예외 상황")
        void charAtException() {
            String test = "abc";

            assertThatThrownBy(() -> { char a = test.charAt(3);})
                    .isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: 3");

            assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { char b = test.charAt(4);})
                    .withMessageMatching("String index out of range: \\d+");
        }
    }
}
