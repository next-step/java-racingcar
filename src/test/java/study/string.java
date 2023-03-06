package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class string {
    @Test
    void split1() {
        final String[] actual = "1,2".split(",");// actual contains [1,2]
        assertThat(actual).containsExactly("1","2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");// actual contains [1,2]
        assertThat(actual).containsExactly("1");
    }

    @Test
    void split3() {
        final String actual = "(1,2)".substring(1,4);// actual contains [1,2]
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void place() {
        final char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    @Test
    void place_valid() {
        final char actual = "abc".charAt(2);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(100));
    }

}
