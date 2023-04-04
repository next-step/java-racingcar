package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("1,2 를 split 했을때 1과 2로 분리된다")
    @Test
    void givenNumbersWhenSplitStringThenContainsOneAndTwo() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("1 콤마로 split 했을때 1만을 포함하는 배열이 반환된다")
    @Test
    void givenNumberWhenSplitWithCommaThenReturnOne() {
        // given
        String input = "1";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).contains("1");
    }

    @DisplayName(" (1,2) 값이 주어졌을때 () 가 제거되고 1,2가 반환된다")
    @Test
    void givenNumbersWithBracketWhenRemoveBracketThenReturnNumbers() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, input.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("abc 값이 주어졌을때 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 수 있다")
    @Test
    void givenStringWhenUsingMethodCharAtThenChar(){
        // given
        String input = "abc";

        // when
        char result = input.charAt(0);

        // then
        assertThat(result).isEqualTo('a');
    }

    @DisplayName("abc 값이 주어졌을때 특정 위치가 벗어난 문자값을 가져오려고 하면 StrungIndexOutOfBoundsException 이 발생한다")
    @Test
    void givenStringWhenUsingMethodCharAtAtOutOfIndexCharThenThrowsException(){
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> {
            char result = input.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}