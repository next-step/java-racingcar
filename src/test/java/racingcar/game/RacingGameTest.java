package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("레이싱 게임 초기 설정 - 주어진 수만큼 반복횟수와 자동차 등록")
    @Test
    void initialize() {
        int countOfCars = 3;
        int round = 2;

        RacingGame racingGame = RacingGame.newGame(countOfCars, round);

        assertThat(racingGame).isNotNull();
    }
}
