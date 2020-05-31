package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @Test
    @DisplayName("여러 개의 문자열과 쉼표 구분자를 포함하는 경우 구분자를 기준으로 분리하여 배열로 반환한다")
    void splitString() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        //then
        // assertThat().containsExactly: 배열의 순서를 보장한다.
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("하나의 문자열인 경우 문자열 하나만 담겨 있는 배열을 반환한다")
    void splitChar() {
        // given
        String input = "1";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("여러 개의 문자열이 소괄호로 감싸져있을 경우 소괄호를 제거한 문자열로 반환한다")
    void substring() {
        // given
        String input = "(1,2)";
        int start = input.indexOf("(");
        int end = input.indexOf(")");

        // when
        String result = input.substring(start + 1, end);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 하나를 가져온다")
    void charAt() {
        // given
        String input = "abc";

        // when
        char result = input.charAt(0);

        // then
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어날 경우 StringIndexOutOfBoundsException을 발생시킨다")
    void charAtException() {
        // given
        String input = "abc";

        // when
        assertThatThrownBy(() -> {
            input.charAt(input.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
