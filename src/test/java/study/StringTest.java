package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("따옴표를 기준으로 문자열을 슬라이싱 할 수 있다")
    @Test
    void splitByComma() {
        //given
        String input = "1,2";
        String delimiter = ",";

        //when
        String[] result = input.split(delimiter);

        //then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("주어진 문자열의 양끝단 괄호들을 제거 할 수 있다")
    @Test
    void substring() {
        //given
        String input = "(1,2)";

        //when
        String incompleteResult = input.substring(1);
        String result = incompleteResult.substring(0, incompleteResult.length() - 1);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("주어진 문자열의 특정인덱스 값에 해당하는 문자를 추출 할 수 있다")
    @Test
    void charAt() {
        //given
        String input = "abc";
        int index = 1;

        //when
        char result = input.charAt(index);

        //then
        assertThat(result).isEqualTo('b');
    }

    @DisplayName("주어진 문자열의 범위 밖의 인덱스 값은 예외를 발생시킬 수 있다")
    @Test
    void charAtWhenIndexIsOutOfBounds() {
        //given
        String input = "abc";
        int index = 5;

        //when && then
        Assertions.assertThatThrownBy(
                () -> input.charAt(index)
        ).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
