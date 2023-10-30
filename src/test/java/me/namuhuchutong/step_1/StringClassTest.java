package me.namuhuchutong.step_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringClassTest {

    @DisplayName(",가 포함된 문자열이 ,로 split했을 때 잘 분리되는지 확인")
    @ParameterizedTest(name = "{index} - given: \"{0}\", result: {1}")
    @MethodSource("givenStringAndExpectedArray")
    void split_string_with_comma(String given, String[] expected) {
        //when
        String[] result = given.split(",");

        //then
        assertThat(result).contains(expected);
    }

    static Stream<Arguments> givenStringAndExpectedArray() {
        return Stream.of(
                Arguments.arguments("1,2", new String[] {"1", "2"}),
                Arguments.arguments("1", new String[] {"1"})
        );
    }

    @DisplayName("\"(1,2)\"가 주어졌을 때 ()를 제거하고 \"1,2\"를 반환")
    @Test
    void remove_brackets() {
        //given
        String given = "(1,2)";
        String expected = "1,2";

        //when
        String result = given.substring(1, given.length() - 1);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("\"abc\"가 주어졌을 때 문자열의 위치 값을 벗어날 경우 예외가 발생")
    @Test
    void throw_exception_when_get_out_of_string_range() {
        //given
        String given = "abc";
        int outOfIndex = given.length();

        //when, then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(
                () -> given.charAt(outOfIndex));
    }

    @DisplayName("\"abc\"가 주어졌을 때 chatAt 메소드를 활용해 해당 문자의 위치를 확인")
    @ParameterizedTest(name = "index: {0}, result: ''{1}''")
    @MethodSource("characterAndIndex")
    void check_character_index_in_abc(int index, char expected) {
        //given
        String given = "abc";

        //when
        char result = given.charAt(index);

        //then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> characterAndIndex() {
        return Stream.of(
                Arguments.arguments(0, 'a'),
                Arguments.arguments(1, 'b'),
                Arguments.arguments(2, 'c')
        );
    }
}
