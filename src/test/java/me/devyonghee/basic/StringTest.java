package me.devyonghee.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열")
class StringTest {

    @Test
    @DisplayName("\"1,2\" 를 \",\" 로 나누면 [1,2]")
    void split() {
        //given
        String oneTwo = "1,2";
        //when
        String[] splitStrings = oneTwo.split(",");
        //then
        assertThat(splitStrings).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\" 를 \",\" 로 나누면 [1]")
    void split_withoutDelimiter() {
        //given
        String one = "1";
        //when
        String[] splitStrings = one.split(",");
        //then
        assertThat(splitStrings).containsExactly(one);
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
}
