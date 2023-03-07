package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class StringTest {
    @Test
    public void split1() {
        final String[] actual = "1,2".split(",");
        System.out.println(Arrays.toString(actual));
        Assertions.assertThat(actual).containsExactly("1", "2");
    }

    @Test
    public void split2() {
        final String[] actual = "7".split(",");
        System.out.println(Arrays.toString(actual));
        Assertions.assertThat(actual).containsExactly("7");
    }


    @Test
    public void split3() {
        final String actual = "(1,2)".substring(1, 4);
        Assertions.assertThat(actual).isEqualTo("1,2");
    }


    @DisplayName("특정 위치의 문자 가져오기")
    @Test
    public void split4() {
        String actual = "stringfinding";

        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> Assertions.assertThat(actual.charAt(0)).isEqualTo('f'));
    }
}


