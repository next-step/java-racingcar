package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("문자열을 ',' 기준으로 나눠서 반환한다.")
    void split() {
        String[] data = "1,2".split(",");

        assertThat(data).contains("1");
        assertThat(data).containsExactly("1", "2");
    }

    @Test
    @DisplayName("괄호를 제외한 나머지 문자열을 반환한다.")
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("넘겨진 문자열의 특정 위치의 문자를 가져오며, 위치가 벗어나면 에러를 발생시킨다.")
    void charAt() {
        String data = "abc";

        assertThat(data.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> data.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
