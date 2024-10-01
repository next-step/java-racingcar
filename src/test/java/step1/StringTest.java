package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringTest {
    @Test
    @DisplayName("'1,2'을 ','로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void splitTwoNum() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("'1'을 ','로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void splitOneNum() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하는지 확인")
    void removeParenthesesUsingSubString() {
        String input = "(1,2)";
        String result = input.substring(1, 4);
        String expected = "1,2";
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    void getCharacterUsingCharAt() {
        String input = "abc";
        char result = input.charAt(0);
        char expected = 'a';
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    void stringIndexOutOfBoundsExceptionTest() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(input.length());
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
