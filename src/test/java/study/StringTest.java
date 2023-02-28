package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {
    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        //actual contains [1, 2]
        System.out.println(Arrays.toString(actual));
        assertThat(actual).containsExactly("1", "2", "3");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String [] actual = "(1,2)".replace("(", "").replace(")", "").split(",");
//        String [] actual1 = "(1,2)".substring(1, 4);
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void charAt() {
        String actual = "abc".substring(1, 2);
        char actual1 = "abc".charAt(2);
        assertThat(actual1).isEqualTo("c");

    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    @Test
    void charAt2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }


}
