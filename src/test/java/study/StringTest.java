package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitMulti(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitSingle(){
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring(){
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("valid index charAt() test")
    void validIndexTest(){
        String input = "abc";
        int validIndex = 0;
        assertThat(input.charAt(validIndex)).isEqualTo('a');

    }

    @Test
    @DisplayName("invalid index charAt() test")
    void invalidIndexTest(){
        String input = "abc";
        int invalidIndex = 4;
        assertThatThrownBy(() -> input.charAt(invalidIndex)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
