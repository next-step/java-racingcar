package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {
    @Test
    void _1_2을_콤마로_split_했을_때_1과_2로_분리된다() {
        String input = "1,2";
        String delimiter = ",";
        assertThat(input.split(delimiter)).containsExactly("1","2");
    }

    @Test
    void _1을_콤마로_split_했을_때_1을_반환한다() {
        String input = "1";
        String delimiter = ",";
        assertThat(input.split(delimiter)).containsExactly("1");
    }

    @Test
    void 괄호를_제거해_반환한다() {
        String input = "(1,2)";
        assertThat(input.substring(1,4)).isEqualTo("1,2");
    }

    @DisplayName("길이_내의_특정_위치의_문자를_반환한다")
    @ParameterizedTest
    @CsvSource(value = {"0, a", "1, b", "2, c"})
    void substing_valid(int position, char expected) {
        String input = "abc";
        assertThat(input.charAt(position)).isEqualTo(expected);
    }

    @DisplayName("길이를_넘는_위치의_문자를_요청하면_예외를_발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void substing_unvalid(int position) {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(position))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: "+ position);
    }
}
