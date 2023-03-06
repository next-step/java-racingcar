package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @Test
    void splite() {
        final String[] actual = "1,2".split(",");
        // actual contains [1, 2]
        // System.out.println(actual.toString());
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void splite2() {
        final String[] actual = "1".split(",");
        // actual contains [1]
        assertThat(actual).containsExactly("1");
    }

    @Test
    void splite3() {
        System.out.println(testFunction("abc",3));
        assertThat(testFunction("abc",3)).contains("c").isInstanceOf(IndexOutOfBoundsException.class);
    }
    private String testFunction (String value, int i)
    {
        return value.substring(i-1, i);
    }

    @Test
    void splite4() {
        final String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 excepton 발생")
    @Test
    void splite5() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }
}
