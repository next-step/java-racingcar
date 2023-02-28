package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class stringTest {
    @Test
    void split1(){
        final String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2(){
        final String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1","2");
    }

    @Test
    void split3(){
        final int actual = "abc".indexOf("b");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void charAt1(){
        final char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo("c");
    }

    @DisplayName("특정 위치의 문자를 가져올때 위치 값을 벗어나면 익셉션 발생")
    @Test
    void charAt2(){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->"abc".charAt(1));
    }
}
