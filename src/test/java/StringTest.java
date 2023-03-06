import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split() {
        String[] actual = "1,2".split(",");

        System.out.println(Arrays.toString(actual));
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void subString() {
        final String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        final char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }

    @DisplayName("특정 위치의 문자를 가져올때 위치값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void charAt2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }

    @Test
    void findLocation() {
        String str = "hello world";
        int actual = 6;
        int result = str.indexOf("world");

        assertThat(actual).isEqualTo(result);
        System.out.println("test");
    }

}
