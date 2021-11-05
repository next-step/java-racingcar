package com.kkambi.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {

    @DisplayName("요구1: '1,2'를 ,로 분리")
    @Test
    void splitJointString() {
        // given
        String targetString = "1,2";
        String expectedString1 = "1";
        String expectedString2 = "2";

        // when
        String[] split = targetString.split(",");

        // then
        assertThat(split).contains(expectedString1);
        assertThat(split).contains(expectedString2);
    }

    @DisplayName("요구1: '1'를 ,로 분리")
    @Test
    void splitSingleString() {
        // given
        String targetString = "1";
        String expectedString = "1";

        // when
        String[] split = targetString.split(",");

        // then
        assertThat(split).containsExactly(expectedString);
    }

    @DisplayName("요구2: '(1,2)'의 괄호 제거")
    @Test
    void removeParenthesis() {
        // given
        String targetString = "(1,2)";
        String expectedString = "1,2";

        // when
        String substring = targetString.substring(1, targetString.indexOf(")"));

        // then
        assertThat(substring).isEqualTo(expectedString);
    }

    @DisplayName("요구3: 특정 위치의 문자 가져오기")
    @Test
    void getCharacter() {
        // given
        String targetString = "abc";
        char expectedCharacter = 'b';

        // when
        char returnedCharacter = targetString.charAt(1);

        // then
        assertThat(returnedCharacter).isEqualTo(expectedCharacter);
    }

    @DisplayName("요구3: 특정 위치 문자를 가져올 때 위치를 벗어나는 경우 예외 발생")
    @Test
    void getOutOfIndexExceptionWhenGettingCharacter() {
        // given
        String targetString = "abc";
        Class<IndexOutOfBoundsException> expectedException = IndexOutOfBoundsException.class;
        int outerIndex = targetString.length();
        String expectedMessage = String.format("String index out of range: %d", targetString.length());

        // when
        // then
        assertThatThrownBy(() -> targetString.charAt(outerIndex))
                .isInstanceOf(expectedException)
                .hasMessageContaining(expectedMessage);
    }
}
