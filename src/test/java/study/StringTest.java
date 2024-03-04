package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("요구사항 1.1. 문자열을 쉼표(,)를 기준으로 분리한다.")
    @Test
    void test1() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        Assertions.assertThat(result)
                .containsExactly("1", "2");
    }

    @DisplayName("요구사항 1.2. 문자열을 쉼표(,)를 기준으로 분리한다.")
    @Test
    void test2() {
        // given
        String input = "1";

        // when
        String[] result = input.split(",");

        // then
        Assertions.assertThat(result)
                .containsExactly("1");
    }

    @DisplayName("요구사항 2.1. 문자열의 앞뒤에 있는 괄호를 제거한다.")
    @Test
    void test3() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, input.length() - 1);

        // then
        Assertions.assertThat(result)
                .isEqualTo("1,2");
    }

    @DisplayName("요구사항 3.1. charAt 메서드를 활용해 특정 인덱스의 문자를 가져온다.")
    @Test
    void test4() {
        // given
        String input = "abc";

        // when
        char result = input.charAt(0);

        // then
        Assertions.assertThat(result)
                .isEqualTo('a');
    }

    @DisplayName("요구사항 3.2. charAt 메서드로 범위를 벗어난 인덱스의 문자를 가져오려고 할 때 예외가 발생한다.")
    @Test
    void test5() {
        // given
        String input = "abc";

        // when / then
        Assertions.assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
