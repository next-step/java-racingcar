import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {



    @Test
    void string_split_test_1() {

        final String input = "1,2";
        String[] numbers = input.split(",");
        assertThat(numbers).containsExactly("1", "2");
    }


    @Test
    void string_split_test_2() {

        final String input = "1";
        String[] numbers = input.split(",");
        assertThat(numbers).containsExactly("1");
    }


    @Test
    void string_test_3() {
        final String input = "(1,2)";
        String output = input.substring(1,4);
        assertThat(output).isEqualTo("1,2");
    }


    @Test
    @DisplayName("문자열의 특정 위치를 성공적으로 반환한다")
    void string_test_4() {
        final String input = "abc";
        char first = input.charAt(0);
        assertThat(first).isEqualTo('a');
    }



    @Test
    @DisplayName("문자열의 특정 위치가 벗어날 경우 예외가 발생한다")
    void string_test_5() {
        final String input = "abc";
        int index = input.length() + 1;
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

}
