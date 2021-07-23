package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("split 으로 특정 문자 기준으로 자르기")
    @Test
    public void split_with_comma() {
        String rawString = "1,2";

        String[] results = rawString.split(",");

        assertThat(results).contains("1", "2");
    }

    @DisplayName("split 문자 없으면 그대로 리턴")
    @Test
    public void split_without_comma() {
        String rawString = "1";

        String[] results = rawString.split(",");

        assertThat(results).containsExactly("1");
    }

    @DisplayName("substring 으로 부분문자열 리턴")
    @Test
    public void uncover_bracket() {
        String rawString = "(1,2)";

        String result = rawString.substring(1, rawString.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 으로 특정 위치 문자 가져오기")
    @Test
    public void get_char() {
        String rawString = "abc";

        char result = rawString.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @DisplayName("charAt 으로 잘못된 위치 요청시 StringIndexOutOfBoundException 발생")
    @Test
    public void get_char_exception() {
        String rawString = "abc";

        assertThatThrownBy(() -> {
            rawString.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("Index: 3, Size: 3");
    }
}
