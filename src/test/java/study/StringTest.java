package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void subString() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 Test")
    void charAt1() {
        char charAt = "abc".charAt(0);
        assertThat(charAt).isEqualTo('a');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값 벗어났을 때 Exception Test")
    void charAt2() {
        int charLength = "abc".length();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            "abc".charAt(charLength+1);
        });
    }
}
