package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        final String[] actual = "1,2".split(",");
        System.out.println(actual);
        assertThat(actual).containsExactly("1","2");
    }

    @Test
    void split2() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring(){
        final String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");

    }
    @Test
    void charAt(){
        final char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }
    @DisplayName("특정 위치 문자 벗어날 시, StringIndexOutOfBoundsException 발생한다.")
    @Test
    void charAt2(){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->"abc".charAt(4));
    }
}
