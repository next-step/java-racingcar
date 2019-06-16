package com.jaeyeonling.racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    private static final String TEST_STRING_INPUT = "리뷰어님, 잘부탁드립니다.";

    @DisplayName("String 값 입력 검증")
    @Test
    void readString() {
        // given
        final InputView inputView = new InputView(new ByteArrayInputStream(TEST_STRING_INPUT.getBytes()));

        // when
        final String readString = inputView.readString();

        // then
        assertThat(readString).isEqualTo(TEST_STRING_INPUT);
    }
}
