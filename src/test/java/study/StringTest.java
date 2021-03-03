package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때, 1과 2로 잘 분리되는지 테스트")
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }


    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때, 1만을 포함하는 배열이 반환되는지 테스트")
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때, substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는지 테스트")
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때, charAt()이 특정 위치의 문자를 가져오는지 테스트")
    void charAt() {
        String data = "abc";

        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("chatAt()이 인덱스를 벗어날 때 StringIndexOutOfBoundsException이 발생하는지 테스트")
    void charAtThrowStringIndexOutOfBoundsException() {
        assertThatThrownBy(() ->
                "abc".charAt(-1)
        ).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");

    }
}
