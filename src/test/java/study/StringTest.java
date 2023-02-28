package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        System.out.println(Arrays.toString(actual));
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        System.out.println(Arrays.toString(actual));
        assertThat(actual).containsExactly("1");
    }

    @Test
    void requirements_2() {
        final String actual = "(1,2)".replace("(", "").replace(")", "");
        System.out.println(actual);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void requirements_3_1() {
        char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    @Test
    void requirements_3_2() {
        String actual = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }
}


