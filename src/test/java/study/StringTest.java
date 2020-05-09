package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("문자열을 쉼표 구분자로 split한다")
    @Test
    void split() {
        String data = "1,2";
        String[] result = data.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("문자열의 바깥 괄호를 제거한다")
    @Test
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("문자열의 길이보다 큰 위치의 문자를 구하면 StringIndexOutOfBoundsException 발생한다")
    @Test
    void charAt() {
        String data = "abc";

        assertThatThrownBy(() -> {
            data.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
