package com.kakao.learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    private static final int SUBSTRING_INDEX = 1;

    @Test
    @DisplayName("split 테스트")
    void splitTest() {
        //given
        String input = "1,2";
        //when
        String[] result = input.split(",");
        //then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 테스트")
    void subStringTest() {
        //given
        String input = "(1,2)";
        //when
        String result = input.substring(SUBSTRING_INDEX, input.length() - SUBSTRING_INDEX);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("charAt 테스트")
    @MethodSource("indexCharAtTestParameters")
    void indexCharAtTest(int index, char expected) {
        //given
        String input = "abc";
        char actual = input.charAt(index);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> indexCharAtTestParameters() {
        return Stream.of(
                Arguments.arguments(0, 'a'),
                Arguments.arguments(1, 'b'),
                Arguments.arguments(2, 'c')
        );
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    void StringIndexOutOfBoundsExceptionTest() {
        String input = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(3)).withMessageMatching("String index out of range: \\d+");
    }
}
