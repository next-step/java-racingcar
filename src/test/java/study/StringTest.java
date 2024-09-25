package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지")
    void split_returns_correct_array_when_string_is_split() {
        var array = "1,2".split(",");
        assertThat(array).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지")
    void split_returns_correct_array_size_when_string_is_split() {
        var array = "1".split(",");
        assertThat(array)
                .hasSize(1)
                .contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는지")
    void substring_returns_correct_string_when_string_is_substring() {
        var str = "(1,2)";
        var result = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지")
    void charAt_returns_correct_index_when_string_is_charAt() {
        var str = "abc";
        assertThat(str.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException가 발생하는지")
    void charAt_throws_exception_when_index_is_out_of_bounds() {
        var str = "abc";
        assertThatThrownBy(() -> str.charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
