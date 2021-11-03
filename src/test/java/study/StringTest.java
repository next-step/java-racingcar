package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void splitTest() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result1).contains("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substringTest() {
        String exmaple = "(1,2)";
        String result = exmaple.substring(exmaple.indexOf("(") + 1, exmaple.indexOf(")"));

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("string의 charAt을 호출할 때 배열의 범위를 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    @Test
    void carAtTest() {
        String example = "abc";
        char first = 'a';
        char second = 'b';
        char third = 'c';

        assertThat(first).isEqualTo(example.charAt(0));
        assertThat(second).isEqualTo(example.charAt(1));
        assertThat(third).isEqualTo(example.charAt(2));

        assertThatThrownBy(() -> {
            example.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 3");
    }
}
