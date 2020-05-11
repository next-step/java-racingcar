package com.cheolhyeonpark.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class StringStudyTest {

    @Test
    @DisplayName("1,2 콤마(,)로 split 하면 1과 2가 포함된 배열이 만들어진다")
    void splitStringByComma() {
        //given
        String inputText = "1,2";

        //when
        String[] splitText = inputText.split(",");

        //then
        assertThat(splitText)
                .contains("1", "2")
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("(1,2)에서 substring 을 사용해 양쪽 괄호를 제거하면 1,2가 반환")
    void removeBracket() {
        //given
        String inputText = "(1,2)";

        //when
        String resultText = inputText.substring(1, inputText.length() - 1);

        //then
        assertThat(resultText).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드에서 문자열 범위를 벗어나면 예외 발생")
    void throwOutOfBoundExceptionUsingCharAt() {
        //given
        String inputText = "abc";

        //when

        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> inputText.charAt(inputText.length()));
    }
}