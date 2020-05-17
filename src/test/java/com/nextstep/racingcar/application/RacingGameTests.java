package com.nextstep.racingcar.application;

import com.nextstep.racingcar.domain.car.CarFactory;
import com.nextstep.racingcar.domain.car.ForceMoveStrategy;
import com.nextstep.racingcar.domain.round.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

        racingGame.run(new CarFactory(), new ForceMoveStrategy());

        List<String> results = racingGame.getResults();
        assertThat(results.get(0)).isEqualTo("-\n-\n-\n");
        assertThat(results.get(1)).isEqualTo("--\n--\n--\n");
    }

    @DisplayName("진행할 라운드 수와 String 리스트를 입력 받아서 객체 생성")
    @Test
    void createByStringListTest() {
        List<String> driverNames = Arrays.asList("poppo", "saul", "ita");
        int round = 5;
        RacingGame racingGame = new RacingGame(driverNames, round);
        assertThat(racingGame).isNotNull();
    }

    @DisplayName("운전자이름 리스트, 라운드 횟수를 전달해서 레이싱 게임 객체 생성 가능")
    @Test
    void runByCarWithDriverNameTest() {
        List<String> driverNames = Arrays.asList("poppo", "saul", "ita");
        int round = 2;
        RacingGame racingGame = new RacingGame(driverNames, round);

        assertThat(racingGame).isNotNull();
    }

    @DisplayName("레이싱 게임 종료 후 진행한 라운드별로 게임 결과를 받을 수 있음 반환받을 수 있음")
    @Test
    void getRacingGameResult() {
        List<String> driverNames = Arrays.asList("poppo", "saul", "ita");
        int round = 2;
        RacingGame racingGame = new RacingGame(driverNames, round);
        racingGame.runByDriversName(new CarFactory(), new ForceMoveStrategy());

        assertThat(racingGame.getRacingGameResult().size()).isEqualTo(round);
        assertThat(racingGame.getRacingGameResult().get(0)).isInstanceOf(RoundResult.class);
    }
}
