package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        // actual contains [1,2]
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void name() {
        final String actual = "(1,2)".substring(1, 4);
        // actual equals "1,2"
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("특정위치릐 문자를 가져올 때 위치 값을 벗어나면 Exception 발생하는지 체크.")
    @Test
    void test3() {
        // 체크
        final char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo("c");
        // 예외 체크
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(
            () -> "abc".charAt(4));
    }


}
