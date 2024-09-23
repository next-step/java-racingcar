package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split() 메소드로 문자열을 분리한다.")
    void split() {
        String[] resultElements = "1,2".split(",");
        assertThat(resultElements).containsExactly("1", "2");

        String[] resultElementOne = "1".split(",");
        assertThat(resultElementOne).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드로 문자열의 특정 범위를 지정하여 문자열을 자른다.")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드로 문자열의 특정 위치의 문자를 가져온다.")
    void chatAt() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 메소드로 문자열의 특정 위치의 문자를 가져올 때, 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
    void charAtException() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");
    }
}
