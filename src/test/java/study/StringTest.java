package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void testSplit() {
        String[] strings = "1,2".split(",");
        assertThat(strings).containsExactly("1","2");

        String[] strings2 = "1".split(",");
        assertThat(strings2).containsExactly("1");
    }

    @Test
    void testSubstring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void testCharAt() {
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("chatAt() 메소드를 활용해 특정 위치를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생한다.")
    void testCharAtIndexOutOfBoundsException() {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
