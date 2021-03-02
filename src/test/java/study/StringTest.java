package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항 1")
    void 요구사항1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");

        String[] result2 = "1".split(",");
        assertThat(result2).contains("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void 요구사항2() {
        String data = "(1,2)";
        String result = data.substring(0,data.length());
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("요구사항 3-1")
    void 요구사항3_1() {
        String data = "abc";
        char result = data.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("요구사항 3-2")
    void 요구사항3_2() {
        String data = "abc";
        assertThatThrownBy(() -> {
            char result = data.charAt(4);
            assertThat(result).isEqualTo('a');
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
