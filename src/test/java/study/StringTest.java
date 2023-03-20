package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        // actual contains [1,2]
        System.out.println(actual[0]);
        System.out.println(actual[1]);
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        // actual contains [1,2]
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName(value = "특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외가 발생한다")
    @Test
    void name() {
        //char actual = "abc".charAt(4);
        //assertThat(actual).isEqualTo('c');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> "abc".charAt(4));
    }


}
