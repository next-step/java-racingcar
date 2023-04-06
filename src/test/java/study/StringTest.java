package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2(){
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
    @DisplayName("test charAt() method")
    void charAt(){
        String input = "abc";
        int validIndex = 0;
        int invalidIndex = 4;

        assertThat(input.charAt(validIndex)).isEqualTo('a');
        assertThatThrownBy(() -> input.charAt(invalidIndex)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
