package com.jaeyeonling.racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    private static final String NEW_LINE = "\n";
    private static final String TEST_INPUT = "리뷰어님, 리뷰해주셔서 감사합니다.";

    private ByteArrayOutputStream outputStream;
    private ResultView resultView;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        resultView = new ResultView(new PrintStream(outputStream));
    }

    @DisplayName("값 출력 검증")
    @Test
    void show() {
        resultView.show(TEST_INPUT);
        assertThat(new String(outputStream.toByteArray())).isEqualTo(TEST_INPUT + NEW_LINE);
    }
}
