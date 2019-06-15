package com.jaeyeonling.racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    private static final String TEST_STRING_INPUT = "리뷰어님, 잘부탁드립니다.";
    private static final int TEST_INT_INPUT = 100;

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

    @DisplayName("int 값 입력 검증")
    @Test
    void readInt() {
        // given
        final InputStream inputStream = new DataInputStream(new InputStream() {
            @Override
            public int read() {
                return TEST_INT_INPUT;
            }
        });
        final InputView inputView = new InputView(inputStream);

        // when
        final int readInt = inputView.readInt();

        // then
        assertThat(readInt).isEqualTo(TEST_INT_INPUT);
    }
}
