package training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void splitExactly1() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String abc = "abc";
        char a = abc.charAt(0);
        assertThat(a).isEqualTo('a');
        char b = abc.charAt(1);
        assertThat(b).isEqualTo('b');
        char c = abc.charAt(2);
        assertThat(c).isEqualTo('c');
    }

    @DisplayName("charAt() 메서드에 String index 범위를 넘어선 값을 주었을 때, StringIndexOutofBoundsException 예외를 던지는지 테스트")
    @Test
    void charAtThrowException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(-1))
                .withMessageContaining("index out of range: -1");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageContaining("index out of range: 3");
    }
}
