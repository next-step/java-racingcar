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
}
