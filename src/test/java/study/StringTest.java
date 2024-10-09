package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("문자열 '1,2'를 ','로 분리하여 두 개의 숫자로 나누어 결과 확인")
    void splitTwoNum() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 '1'을 ','로 분리하여 하나의 숫자를 포함하는 배열 확인")
    void splitOneNum() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메서드로 문자열 '(1,2)'에서 괄호를 제거하고 내용 추출")
    void substringParentheses() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메서드를 사용하여 특정 위치의 문자 추출")
    void getCharacterUsingCharAt() {
        String str = "abc";
        char result = str.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어날 경우 StringIndexOutOfBoundsException 예외 발생 확인")
    void checkIndexOutOfBounds() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3"); // String index out of range: 3
    }

}
