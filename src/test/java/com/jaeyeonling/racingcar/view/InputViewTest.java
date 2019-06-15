package com.jaeyeonling.racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    private static final String TEST_INPUT = "리뷰어님, 잘부탁드립니다.";

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView(new ByteArrayInputStream(TEST_INPUT.getBytes()));
    }

    @DisplayName("값 입력 검증")
    @Test
    void readFromConsole() {
        assertThat(inputView.readFromConsole()).isEqualTo(TEST_INPUT);
    }
}
