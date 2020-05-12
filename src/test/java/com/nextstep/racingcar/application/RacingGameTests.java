package com.nextstep.racingcar.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTests {
    @DisplayName("진행할 라운드 수와 차량 대수를 입력 받아서 객체 생성")
    @Test
    void createTest() {
        int carNumber = 3;
        int round = 5;
        RacingGame racingGame = new RacingGame(carNumber, round);
        assertThat(racingGame).isNotNull();
    }
}
