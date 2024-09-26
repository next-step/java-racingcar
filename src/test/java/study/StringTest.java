package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @DisplayName("콤마를 기준으로 값이 분리된다.")
    @Test
    void split_value_with_comma() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("콤마가 없을 때에도 콤마를 기준으로 값이 분리된다.")
    @Test
    void split_valueWithoutComma_with_comma() {
        String given = "1";

        String[] result = given.split(",");

        assertThat(result).containsExactly(given);
    }

    @DisplayName("양 끝에 있는 괄호를 제거한다.")
    @Test
    void remove_side_parentheses() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("인자로 전달하는 index 값이 범위를 벗어나면 StringIndexOutOfBoundsException을 던진다.")
    @Test
    void throw_StringIndexOutOfBoundsException_when_index_is_out_of_bounds() {
        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
