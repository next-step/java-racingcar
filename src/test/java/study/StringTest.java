package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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


}
