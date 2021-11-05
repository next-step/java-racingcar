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
        // when
        String[] split = "1,2".split(",");

        // then
        assertThat(split).contains("1");
        assertThat(split).contains("2");
    }

    @DisplayName("요구1: '1'를 ,로 분리")
    @Test
    void splitSingleString() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @DisplayName("요구2: '(1,2)'의 괄호 제거")
    @Test
    void removeParenthesis() {
        // given
        String targetString = "(1,2)";

        // when
        // then
        assertThat(targetString.substring(1, targetString.indexOf(")"))).isEqualTo("1,2");
    }

    @DisplayName("요구3: 특정 위치의 문자 가져오기")
    @Test
    void getCharacter() {
        assertThat("abc".charAt(1)).isEqualTo('b');
    }

    @DisplayName("요구3: 특정 위치 문자를 가져올 때 위치를 벗어나는 경우 예외 발생")
    @Test
    void getOutOfIndexExceptionWhenGettingCharacter() {
        // given
        String targetString = "abc";

        // when
        // then
        assertThatThrownBy(() -> targetString.charAt(targetString.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", targetString.length()));
    }
}
