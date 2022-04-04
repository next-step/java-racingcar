package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열")
class StringTest {

    @ParameterizedTest(name = "[{index}] {0}를 분리하면 {1} ")
    @DisplayName("\",\" 분리")
    @MethodSource
    void split(String target, String[] expected) {
        //when
        String[] splitStrings = target.split(",");
        //then
        assertThat(splitStrings).containsExactly(expected);
    }

    @Test
    @DisplayName("앞뒤 괄호 제거")
    void substring_bracket() {
        //given
        String oneTwoWithBracket = "(1,2)";
        //when
        String oneTwo = oneTwoWithBracket.substring(1, oneTwoWithBracket.length() - 1);
        //then
        assertThat(oneTwo).isEqualTo("1,2");
    }

    @ParameterizedTest(name = "[{index}] {0} 위치의 문자는 {1}")
    @DisplayName("\"abc\" 특정 위치 문자 조회")
    @CsvSource({"0,a", "1,b", "2,c"})
    void charAt_abc(int index, char expected) {
        //given
        String abc = "abc";
        //when
        char characterOfAbc = abc.charAt(index);
        //then
        assertThat(characterOfAbc).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] {0} 위치의 문자 조회 불가능")
    @DisplayName("\"abc\" 길이를 벗어난 위치의 문자를 조회하면 IndexOutOfBoundsException")
    @ValueSource(ints = {Integer.MIN_VALUE, Integer.MAX_VALUE})
    void charAt_outOfLength_thrownIndexOutOfBoundsException(int index) {
        //given
        String abc = "abc";
        //when
        ThrowingCallable charAtCallable = () -> abc.charAt(index);
        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(charAtCallable)
                .withMessageStartingWith("String index out of range");
    }

    private static Stream<Arguments> split() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }
}
