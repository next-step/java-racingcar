package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitTest {

    @Test
    void test_split_1() {
        String input = "1,2";

        String[] result = input.split(",");

        assertThat(result).containsExactly("1", "2"); 
    }

    @Test
    void test_split_2() {
        String input = "1";

        String[] result = input.split(",");

        assertThat(result).containsExactly("1"); 
    }

    @Test
    void test_substring() {
        String input = "(1,2)";

        String result = input.substring(1, input.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 정상적으로 가져옴")
    void test_charat_1() {
        String input = "abc";

        char result = input.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외가 발생")
    void test_charat_2() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range");
    }
}