package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @DisplayName("split() 학습테스트")
    @Test
    void split() {
        //given
        String given = "1,2";
        String delimiter = ",";

        //when
        String[] result = given.split(delimiter);

        //then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("substring() 학습테스트")
    @Test
    void substring() {
        //given
        String given = "(1,2)";
        int startParenthesisIndex = given.indexOf('(');
        int endParenthesisIndex = given.indexOf(')');

        //when
        String result = given.substring(startParenthesisIndex + 1, endParenthesisIndex);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt() 특정 위치의 문자를 가져올때 위치 값을 벗어나면 StringIndexOutOfBoundException 이 발생한다.")
    @Test
    void charAtFunctionTest() {
        //given
        String given = "abc";
        int indexOutOfBound = given.length();

        //when,then
        assertThatThrownBy(() -> given.charAt(indexOutOfBound))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }

}
