package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split_검증() {
        // given
        String given1 = "1,2";
        String given2 = "1";

        // when
        String[] result1 = given1.split(",");
        String[] result2 = given2.split(",");

        // then
        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substring_후_split() {
        // given
        String given = "(1,2)";

        // when
        String result = given.substring(1, given.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest(name = "문자열에 {0}로 charAt을 하면 {1}가 반환된다") // displayName 대체
    @MethodSource("charAtTestParameter")
    void charAt_검증(int index, Character expected) {
        String given = "abc";

        assertThat(given.charAt(index))
                .isEqualTo(expected);
    }

    static Stream<Arguments> charAtTestParameter() {
        return Stream.of(
                Arguments.of(0, 'a'),
                Arguments.of(2, 'c')
        );
    }

    @ParameterizedTest(name = "문자열에 {0}로 charAt을 하면 {1}가 반환된다") // displayName 대체
    @MethodSource("charAtExceptionTestParameter")
    void charAt_execption(int index, Class<Exception> exception) {
        String given = "abc";

        assertThatThrownBy(() -> given.charAt(index))
                .isInstanceOf(exception)
                .hasMessageContaining("index out of range: " + index);
    }

    static Stream<Arguments> charAtExceptionTestParameter() {
        return Stream.of(
                Arguments.of(-1, IndexOutOfBoundsException.class)
        );
    }

}
