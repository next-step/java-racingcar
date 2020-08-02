package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitTest() {
        String[] data = "1,2".split(",");

        assertThat(data).contains("1", "2");
        // 순서까지 보장하고 싶은 경우 containsExactly
        assertThat(data).containsExactly("1", "2");
    }

    @Test
    void subStrTest() {
        String input = new String("(1,2)");

        String subStr = input.substring(1, 4);

        assertThat(subStr.equals("1,2")).isTrue();
    }

    @Test
    void charAtTest() {
        String input = new String("abc");

        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

