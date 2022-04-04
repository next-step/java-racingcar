package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 \",\"로 split 했을 때 1과 2로 분리된다.")
    void split_multiple() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 \",\"로 split 했을 때 1을 포함하는 배열이 반환된다.")
    void split_single() {
        String[] result = "1".split(",");
        Assertions.assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 ()을 제거하고 \"1,2\"를 반환한다.")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String::charAt로 특정 위치의 문자를 가져온다.")
    void charAt() {
        String value = "abc";
        char first = value.charAt(0);
        char second = value.charAt(1);
        char third = value.charAt(2);

        Assertions.assertThat(first).isEqualTo('a');
        Assertions.assertThat(second).isEqualTo('b');
        Assertions.assertThat(third).isEqualTo('c');
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAt_exception() {
        String value = "abc";

        Assertions.assertThatThrownBy(() -> value.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

}
