import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void requirements_1() {
        //given
        String input1 = "1,2";
        String input2 = "1";

        String[] expected1 = {"1", "2"};
        String[] expected2 = {"1"};

        //when
        String[] actual1 = input1.split(",");
        String[] actual2 = input2.split(",");

        //then
        assertThat(actual1).contains(expected1);
        assertThat(actual2).containsExactly(expected2);
    }

    @Test
    void requirements_2() {
        //given
        String input = "(1,2)";
        String expected = "1,2";

        //when
        String actual = requirements_2_method(input);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    private String requirements_2_method(String input) {
        return input.substring(1, 4);
    }

    @Test
    @DisplayName("charAt() 메소드를 사용해 특정 위치의 문자를 가져오는 테스트, 위치 값을 벗어나면 StringIndexOutOfBoundsException")
    void requirements_3() {
        //given
        String input = "abc";
        char expected1 = 'a';
        char expected2 = 'b';
        char expected3 = 'c';

        //when
        char actual1 = input.charAt(0);
        char actual2 = input.charAt(1);
        char actual3 = input.charAt(2);

        //then
        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);
        assertThatThrownBy(()-> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
