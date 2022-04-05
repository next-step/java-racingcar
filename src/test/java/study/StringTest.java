package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Test
    @DisplayName("String split method test")
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String substring method test")
    void substring() {
        String str = "(1,2)";
        int endIndex = str.length() - 1;

        String result = str.substring(1, endIndex);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt method test")
    void charAt() {
        String str = "abc";

        char result = str.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException test when use charAt")
    void charAtStringIndexOutOfBoundsException() {
        String str = "abc";

        assertThrows(StringIndexOutOfBoundsException.class, () -> str.charAt(3));
    }
}
