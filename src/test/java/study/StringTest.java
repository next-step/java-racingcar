package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitOneString() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("문자열 abc에서 1 위치의 문자를 가져오면 b이다.")
    @Test
    void charAt() {
        String abc = "abc";
        assertThat(abc.charAt(1)).isEqualTo('b');
    }

    @DisplayName("문자열 abc에서 3 위치의 문자를 가져오면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void charAtThrowException() {
        String abc = "abc";
        assertThatThrownBy(() -> {
            abc.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
