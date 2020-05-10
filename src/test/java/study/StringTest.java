package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("입력 문자열을 ,를 기준으로 분리한다")
    @Test
    void split() {
        //given
        String input = "1,2";

        //when
        String[] expected = "1,2".split(",");

        //then
        assertThat(expected).containsExactly("1", "2");
    }

    @DisplayName("괄호와 ,로 구분된 숫자들이 들어오면 괄호를 제거하고 반환한다")
    @Test
    void remove() {
        //given
        String input = "(1,2)";
        String expected = "1,2";

        //when
        String result = input.substring(1, input.length() - 1);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열의 범위를 벗어나는 위치를 가져오려고 할 때 익셉션이 발생한다")
    @ValueSource(ints = {3, -1})
    @ParameterizedTest
    void charAtIndexError(int index) {
        //given
        String input = "abc";

        //when
        //then
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: %d", index);
    }

}
