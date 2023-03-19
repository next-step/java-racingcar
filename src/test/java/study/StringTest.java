package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String[] split = "1,2".split(",");
        System.out.println(Arrays.toString(split));
        assertThat(split).containsExactly("1","2","3");
    }

    @Test
    void split2() {
        String[] split2 = "1".split(",");
        System.out.println(Arrays.toString(split2));
        assertThat(split2).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }


    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외가 발생한다.")
    @Test
    void charAt2() {
        char actual = "abc".charAt(4);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }


}
