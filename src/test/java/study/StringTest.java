package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1 과 2 분리 테스트")
    void split_array_test() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("1 배열 반환 테스트")
    void return_array_test() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 자르기 테스트")
    void cut_string_test() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    void get_inedx_char_test() {
        char result = "abc".charAt(2);
        assertThat(result).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 위치 확인 에외 테스트")
    void string_index_exception_Test() {
        String string = "abc";
        assertThatThrownBy(() -> string.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
