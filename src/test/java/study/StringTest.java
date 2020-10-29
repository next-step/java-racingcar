package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String givenString = "(1,2)";
        String substring = givenString.substring(givenString.indexOf("(") + 1, givenString.indexOf(")"));
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String givenString = "abc";
        char charAtZero = givenString.charAt(0);
        assertThat(charAtZero).isEqualTo('a');
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 확인 테스트")
    void charAtWithStringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            String givenString = "abc";
            char charAtZero = givenString.charAt(givenString.length() + 1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    
}
