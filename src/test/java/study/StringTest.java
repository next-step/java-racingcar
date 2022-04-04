package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void splitOneAndTwo() {
        String givenString = "1,2";
        String[] result = givenString.split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void splitOneContainsExactlyTest() {
        String givenString = "1";
        String[] result = givenString.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substringRoundBracketsTest() {
        String givenString = "(1,2)";

        String result = givenString.substring(1, givenString.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Req.3 - charAt() 메서드 성공 테스트")
    void charAtSuccessTest() {
        String givenString = "abc";

        char firstCharacter = givenString.charAt(0);
        char secondCharacter = givenString.charAt(1);
        char thirdCharacter = givenString.charAt(2);

        assertThat(firstCharacter).isEqualTo('a');
        assertThat(secondCharacter).isEqualTo('b');
        assertThat(thirdCharacter).isEqualTo('c');
    }

    @Test
    @DisplayName("Req.3 - charAt() IndexOutOfBounds 실패 테스트")
    void charAtFailureTest() {
        String givenString = "abc";

        // String index out of range: 4
        assertThatThrownBy(() -> {
            char indexOutOfBoundCharacter = givenString.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
