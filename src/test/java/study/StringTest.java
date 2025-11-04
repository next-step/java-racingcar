package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt()를 사용하여 인덱스 값을 가져온다")
    @Test
    void charAt() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @DisplayName("charAt()에서 문자열 범위 밖 인덱스 접근 시 StringIndexOutOfBoundsException 발생")
    @Test
    void charAt_stringIndexOutOfBoundsException() {
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of bounds for");
    }
}