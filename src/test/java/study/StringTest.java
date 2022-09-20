package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("1,2 는 1과 2로 분리된다")
    @Test
    void split1() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("1은 1로 분리된다.")
    @Test
    void split2() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @DisplayName("(1,2)가 1,2로 반환된다")
    @Test
    void substring() {
        String string = "(1,2)";
        String result = string.substring(1, string.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 으로 문자열에서 특정 위치의 문자를 가져온다")
    @Test
    void charAt() {
        char result0 = "abc".charAt(0);
        char result1 = "abc".charAt(1);
        char result2 = "abc".charAt(2);

        assertThat(result0).isEqualTo('a');
        assertThat(result1).isEqualTo('b');
        assertThat(result2).isEqualTo('c');
    }

    @DisplayName("charAt 에서 위치 값을 벗어나면 예외가 발생")
    @Test
    void charAt_outOfBoundsException() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
