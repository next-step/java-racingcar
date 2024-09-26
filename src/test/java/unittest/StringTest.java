package unittest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split_string() {
        String test = "1,2";

        String[] split = split(test);

        assertThat(split).contains("1", "2");
    }

    @Test
    void split_single_string() {
        String test = "1";

        String[] split = split(test);

        assertThat(split).containsExactly("1");
    }

    private String[] split(String target) {
        return target.split(",");
    }

    @Test
    void remove_str() {
        String test = "(1,2)";

        String removed = test.substring(test.indexOf("(") + 1, test.indexOf(")"));

        assertThat(removed).isEqualTo("1,2");
    }

    @Test
    @DisplayName("주어진 문자열에서 인덱스를 가지고 특정 문자를 가져온다")
    void get_specific_char() {
        String test = "abc";

        char target = 'c';
        char result = specificChar(test, 2);

        assertThat(result).isEqualTo(target);
    }

    @Test
    @DisplayName("주어진 문자열의 길이를 넘어가는 인덱스가 주어질 때 예외가 발생한다")
    void throw_out_of_bound_exception() {
        String test = "abc";

        Assertions.assertThatThrownBy(() -> specificChar(test, test.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.valueOf(test.length()));
    }

    private char specificChar(String str, int index) {
        return str.charAt(index);
    }

}
