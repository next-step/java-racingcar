package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

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

    @DisplayName("[study]음수 문자열을 parseInt() 적용하면 음수로 정상 전환하여 반환한다.")
    @Test
    void test_about_Integer_parseInt() {
        assertThat(Integer.parseInt("-1")).isEqualTo(-1);
    }

    @DisplayName("[study]빈 문자열에 parseInt() 적용하면 NumberFormatException이 발생한다.")
    @Test
    void test_about_Integer_parseInt2() {
        assertThatThrownBy(() -> Integer.parseInt("")).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("[study]문자열이 //로 시작하고 그 뒤에 오는 임의의 문자에 줄바꿈 문자가 포함되어 있는지 체크한다. ")
    @Test
    void test_about_matches() {
        String pattern = "^//.*\\n.*";

        assertThat("//@\n".matches(pattern)).isTrue();
    }

    @DisplayName("[study]문자열을 원하는 횟수만큼 반복 출력한다.")
    @Test
    void return_String_repeatedAs_argument() {
        assertThat("-".repeat(5)).isEqualTo("-----");
        assertThat("-".repeat(Math.max(0, -1))).isEmpty();
    }

    @DisplayName("[study]StringJoiner를 이용해 리스트 원소들을 콤마로 연결한다.")
    @Test
    void connect_values_with_comma_using_StringJoiner() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        stringJoiner.add("moon");
        stringJoiner.add("yoon");
        stringJoiner.add("ji");
        assertThat(stringJoiner.toString()).isEqualTo("moon, yoon, ji");
    }
}
