package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("요구사항1 - split()을 활용해 \"1,2\" 나누기")
    void split() {
        String[] array = "1,2".split(",");

        assertThat(array).contains("1");
        assertThat(array).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1 - split()을 활용해 \"1\" 나누기")
    void splitOneElementArray() {
        String[] oneElementArray = "1".split(",");

        assertThat(oneElementArray).contains("1");
        assertThat(oneElementArray).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 - substring을 활용해 문자열 자르기")
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - charAt()을 활용해 특정 위치의 문자 가져오기")
    void charAt() {
        String data = "abc";

        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항3 - charAt()에서 index가 벗어났을 때 오류 발생")
    void charAtStringIndexOutOfBoundsException() {
        String data = "abc";

        assertThatThrownBy(() -> {
            data.charAt(100);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
