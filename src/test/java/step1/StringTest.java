package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringTest {
    @Test
    void splitString() {
        String input = "1,2";
        assertThat(input.split(",")).containsExactly("1", "2");
    }

    @Test
    void splitStringListCheck() {
        String input = "1";
        String[] result = input.split(",");
        String[] expected = new String[]{"1"};
        assertArrayEquals(expected, result, "split result incorrect");
    }

    @Test
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        String expected = "1,2";
        assertEquals(expected, result, "wrong substring result");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기")
    void charAtTest() {
        String inputString = "abc";
        int inputIndex = 1;
        char expected = 'b';
        assertThat(inputString.charAt(inputIndex)).isEqualTo(expected);
    }

    @Test
    @DisplayName("특정 문자가 주어졌을 때 charAt 메소드를 사용해 특정 위치의 문자를 가져온다")
    void getCharIndex() {
        String input = "abc";
        int idx = 99;
        assertThatThrownBy(() -> input.charAt(idx))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(idx));
    }
}
