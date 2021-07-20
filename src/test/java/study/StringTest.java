package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName(",로 split을 했을 때 분리가 잘 되는지 확인")
    void split_test_01() {
        //given
        String input = "1,2";
        String[] expect = {"1", "2"};

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly(expect);
    }

    @Test
    @DisplayName("1, 로 split을 했을 때 1만 포함하는 배열이 반환되는지 확인")
    void split_test_02() {
        //given
        String input = "1,";
        String[] expect = {"1"};

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).contains("1");
        assertThat(result).containsExactly(expect);
    }

    @Test
    @DisplayName("감싸진 괄호를 제거한다")
    void remove_parentheses_test() {
        //given
        String input = "(1,2)";
        String expect = "1,2";

        //when
        String result = input.substring(1, input.length() - 1);

        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("charAt()을 활용하여 특정 위치의 문자를 가져온다")
    void charAt_test() {
        //given
        String input = "abc";

        //when
        char result = input.charAt(0);

        //then
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt()을 활용할 때 위치를 벗어났을 시 exception이 발생한다")
    void charAt_exception_test_01() {
        //given
        String input = "abc";

        //when, then
        assertThatThrownBy(() ->
            input.charAt(4)
        ).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 4");
    }

    @Test
    @DisplayName("charAt()을 활용할 때 위치를 벗어났을 시 exception이 발생한다")
    void charAt_exception_test_02() {
        //given
        String input = "abc";

        //when, then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() ->
                input.charAt(4)
        ).withMessageMatching("String index out of range: \\d+");
    }
}
