package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    @Test
    @DisplayName("요구사항1")
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
        assertThat(data).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항2")
    void subString() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() -1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3")
    void stringCharAt() {
        String data = "abc";

        char a = data.charAt(0);
        char b = data.charAt(1);
        char c = data.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');

        // StringIndexOutOfBoundsException
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> data.charAt(data.length())).withMessageMatching("String index out of range: \\d+");
    }
}
