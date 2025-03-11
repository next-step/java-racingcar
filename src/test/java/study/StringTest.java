package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitA() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void splitB() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("charAt() 메서드로 특정 위치의 문자를 가져온다.")
    void chatAtIndex() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() 메서드 사용 시 인덱스 초과로 예외 발생")
    void charAtThrow() {
        String str = "abc";

        assertThatThrownBy(() ->  str.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}
