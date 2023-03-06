package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] actual = "1,2".split(",");
        System.out.println("Arrays.toString(actual) = " + Arrays.toString(actual));
        assertThat(actual).containsExactly("1", "2");
    }
    @Test
    void split2() {
        String[] actual = "1".split(",");
        System.out.println("Arrays.toString(actual) = " + Arrays.toString(actual));
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        final char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치값을 벗어나면 StringIndexOutOfBoundsException 발생")
    void charAt2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> "abc".charAt(4));
    }

}
