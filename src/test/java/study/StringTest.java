package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("1, 2가 ,로 스플릿하면 1 2 로 분리된다.")
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("(1, 2) 값이 주어지면 () 를 제거하고 1,2 를 반환한다.")
    void delete_bracket() {
        String given = "(1,2)";
        String substring = given.substring(1, given.length() - 1);

        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 charAt 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void char_at() {
        String abc = "abc";

        char a = abc.charAt(0);
        char b = abc.charAt(1);
        char c = abc.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt으로 문자열 배열 조회시 index범위 넘어서면 IndexOutOfBoundsException을 던진다.")
    void string_char_at_out_of_index() {
        assertThatThrownBy(() -> {
            String abc = "abc";
            char c = abc.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");

    }

    @Test
    @DisplayName("charAt으로 문자열 배열 조회시 index범위 넘어서면 IndexOutOfBoundsException을 던진다. 2")
    void string_char_at_out_of_index2() {

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            String abc = "abc";
            char c = abc.charAt(3);
        }).withMessageMatching("String index out of range: 3");
    }

}
