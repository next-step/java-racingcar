package com.cheolhyeonpark.step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class StringStudyTest {

    @Test
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
    void removeBracket() {
        //given
        String inputText = "(1,2)";

        //when
        String resultText = inputText.substring(1, inputText.length() - 1);

        //then
        assertThat(resultText).isEqualTo("1,2");
    }

    @Test
    void throwOutOfBoundExceptionUsingCharAt() {
        //given
        String inputText = "abc";

        //when

        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> inputText.charAt(inputText.length()));
    }
}