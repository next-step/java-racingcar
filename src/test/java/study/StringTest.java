package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split 메서드를 이용하여 1과 2를 분리할 수 있다.")
    void split() {
        String numbers = "1,2";
        String[] result = numbers.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 메서드를 이용하여 괄호를 제거할 수 있다.")
    void substring() {
        String numbers = "(1,2)";
        String result = numbers.substring(numbers.indexOf("(") + 1, numbers.indexOf(")"));

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메서드를 이용하여 특정 위치의 문자를 가져올 수 있다.")
    void charAt() {
        String input = "abc";
        char result1 = input.charAt(0);
        char result2 = input.charAt(1);
        char result3 = input.charAt(2);
        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('b');
        assertThat(result3).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메서드를 활용해 특정 위치의 값을 벗어나면 exception 이 발생한다.")
    void charAtException() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
