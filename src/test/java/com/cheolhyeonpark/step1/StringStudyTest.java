package com.cheolhyeonpark.step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringStudyTest {

    @Test
    void splitStringByComma() {
        //given
        String inputText = "1,2";

        //when
        String[] splitedText = inputText.split(",");

        //then
        assertThat(splitedText)
                .contains("1", "2")
                .containsExactly("1", "2");
    }
}