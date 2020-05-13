package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.ForceMoveStrategy;
import com.nextstep.racingcar.domain.car.RandomMoveCarFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("게임을 1라운드 진행하고 결과 확인")
    @Test
    void checkResultTest() {
        int carNumber = 3;
        int round = 2;
        RacingGame racingGame = new RacingGame(carNumber, round);

        racingGame.run(new RandomMoveCarFactory(), new ForceMoveStrategy());

        List<String> results = racingGame.getResults();
        assertThat(results.get(0)).isEqualTo("-\n-\n-\n");
        assertThat(results.get(1)).isEqualTo("--\n--\n--\n");
    }
}
