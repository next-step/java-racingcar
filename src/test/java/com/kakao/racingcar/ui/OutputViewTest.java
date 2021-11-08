package com.kakao.racingcar.ui;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void joinLine() {
        String joinLine = OutputView.joinLine(3);
        assertThat(joinLine).isEqualTo("---");
    }
}
