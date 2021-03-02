package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char data = "abc".charAt(2);
        assertThat(data).isEqualTo('c');
    }

    @DisplayName("charAt() 특정범위를 벗어날 경우")
    @Test
    void StringIndexOutOfBoundsExceptionTest() {

        assertThatThrownBy(() -> {
            char data = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
