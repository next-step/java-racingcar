package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("구분자로 문자열이 잘 나뉘는지 테스트")
    @Test
    void split_one_two() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("구분자 없는 문자열도 잘 반환되는지 테스트")
    @Test
    void split_only_one() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("문자열에 포함된 양 끝 괄호 제거 테스트")
    @Test
    void remove_bracket() {
        // assignment
        final String origin = "(1,2)";

        // act
        String result = origin.substring(1, origin.length() - 1);

        // assertion
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("인덱스를 벗어난 위치의 문자열 접근 Exception 발생 테스트")
    @Test
    void get_specific_character() {
        // assignment
        final String origin = "abc";

        // act
        Character first = origin.charAt(0);
        Character second = origin.charAt(1);
        Character third = origin.charAt(2);

        // assertion
        assertThat(first).isEqualTo('a');
        assertThat(second).isEqualTo('b');
        assertThat(third).isEqualTo('c');

        assertThatThrownBy(() -> origin.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
                                                  .hasMessageContaining("String index out of range: 3");
    }
}
