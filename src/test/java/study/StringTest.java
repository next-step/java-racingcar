package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1","2");
    }
    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }
    @Test
    void split3() {
        String str = "(1,2)";
        String actual = str.replaceAll("[\\(\\)]","");
        assertThat(actual).isEqualTo("1,2");
    }
    @Test
    void split4() {
        String str = "abc";
        char actual = str.charAt(0);
        assertThat(actual).isEqualTo('a');
    }
    @Test
    @DisplayName("위치 넘어가서 에러 발생")
    void split5() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }
}

