package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split1() {
        String[] actual = "1,2".split(",");
        //actual contains [1,2]
        System.out.println(Arrays.toString(actual));
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] actual = "1".split(",");
        //actual contains [1,2]
        System.out.println(Arrays.toString(actual));
        assertThat(actual).containsExactly("1");
    }

    @Test
    void split3() {
        String actual = "(1,2)".replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9,. ]", "");
        //actual contains [1,2]
        System.out.println(actual);

        String acutal1 = "(1,2)".substring(1, 3);
        assertThat(acutal1).contains("1,2");

        //assertThat(actual).contains("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringOutOfBoundsException이 발생한다.")
    @Test
    void split4() {
        char actual = "abc".charAt(4);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->"abc".charAt(4));
    }
}
