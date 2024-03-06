package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring()
    {
        String input = "(1,2)";
        String result = input.substring(1,input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("올바른 위치의 문자를 가져옴")
    void charAtValid()
    {
        String input = "abc";
        int idx = 1;
        char result = input.charAt(idx);

        assertEquals('b', result);
    }

    @Test
    @DisplayName("위치 값을 벗어나면 예외 발생")
    void charAtInvalid()
    {
        String input = "abc";
        int invalidIdx = 10;
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            char result = input.charAt(invalidIdx);
        });
    }
}