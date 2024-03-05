package study.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringTest {

    @ParameterizedTest
    @MethodSource("splitParameter")
    void split(String input, String[] result) {
        String[] splitResult = input.split(",");
        Assertions.assertThat(splitResult).containsExactly(result);
    }

    public static Stream<Arguments> splitParameter() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"}));
    }

    @Test
    void subString() {
        String input = "(1,2)";
        Assertions.assertThat(input.substring(1,4)).isEqualTo("1,2");
    }

    @DisplayName("charAt 성공테스트")
    @Test
    void charAt() {
        String input = "abc";
        Assertions.assertThat(input.charAt(0)).isEqualTo('a');
    }

    @DisplayName("초과된 인덱스범위를 요청할 경우 IndexOutOfBoundsException 예외를 던진다.")
    @Test
    void charAtWithExceededIndexThenThrowIndexOutOfBoundsException() {
        String input = "abc";
        Assertions.assertThatThrownBy(() -> input.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
