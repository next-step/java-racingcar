package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        final String[] actual = "1,2".split(",");
        // actual contains [1, 2]
        System.out.println(Arrays.toString(actual));
        assertThat(actual).containsExactly("1","2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void subString() {
        final String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void subString2() {
        assertThatThrownBy(() -> {
            "abc".substring(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range");
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    @Test
    void charAt2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }
}
