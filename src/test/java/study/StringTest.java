package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    void split1() {
        String[] actual = "1,2".split(",");
        // actual contains [1,2]
        System.out.println(Arrays.toString(actual));

        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2(){
        final String actual = "(1,2)".substring(1,4);

        assertThat(actual).isEqualTo(
                "1,2");
    }


    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외가 발생한다.")
    @Test
    void split3(){
//        char actual = "abc".charAt(2);
//        assertThat(actual).isEqualTo('b');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->"abc".charAt(4));
    }


}
