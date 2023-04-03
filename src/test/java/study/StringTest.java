package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @DisplayName("split을 통해 콤마로 구분된 문자열을 각각의 원소로 나눌 수 있다.")
    @Test
    void splitTwoValues() {
        //GIVEN
        String src = "1,2";


        //WHEN
        String[] result = src.split(",");

        //THEN
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("split을 통해 콤마로 구분된 단일 원소를 가지고 있는 문자열로부터 원소를 추출할 수 있다.")
    @Test
    void splitOneValue() {
        //GIVEN
        String src = "1,";

        //WHEN
        String[] result = src.split(",");

        //THEN
        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring을 통해 괄호로 감싸진 문자열에서 괄호를 제외한 부분의 문자열을 얻을 수 있다.")
    @Test
    void substringParentheses() {
        //GIVEN
        String src = "(1,2)";

        //WHEN
        String result = src.substring(1, src.length() - 1);

        //THEN
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("chatAt을 통해 문자열로부터 각 인덱스별 문자를 얻을 수 있다.")
    @Test
    void chatAt() {
        //GIVEN
        String src = "abc";

        //WHEN
        char a = src.charAt(0);
        char b = src.charAt(1);
        char c = src.charAt(2);

        //THEN
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @DisplayName("문자열의 길이보다 긴 인덱스로 chatAt 요청을 하면 OutOfBoundException이 발생한다.")
    @Test
    void charAtIndexOver() {
        //GIVEN
        String src = "abc";

        //WHEN
        //THEN
        assertThatThrownBy(() -> src.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @DisplayName("음수인 인덱스로 chatAt 요청을 하면 OutOfBoundException이 발생한다.")
    @Test
    void charAtNegativeIndex() {
        //GIVEN
        String src = "abc";

        //WHEN
        //THEN
        assertThatThrownBy(() -> src.charAt(-2))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
