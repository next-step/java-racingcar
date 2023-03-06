package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        final String[] actual = "1*2".split("\\*");
        System.out.println(Arrays.toString(actual));
        //Assertions.<String>assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2() {
        final String actual2 = "(1,2)".substring(1, 4);
        System.out.println(actual2);
        //Assertions.<String>assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void substing(){
        final String actual = "(1,2)".substring(1,5);
        //assertThat(actual).isEqualTo("1,2");
        System.out.println(actual);
    }

    @DisplayName("특정 위치의 문자를 가져올때 위치 값을 벗어나면 StringIndexOutOfBoundsException 예와 발상")
    @Test
    void charAt() {
        final char actual = "abc".charAt(1);
        System.out.println(actual);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }

}


