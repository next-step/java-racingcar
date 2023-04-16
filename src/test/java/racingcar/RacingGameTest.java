package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임 생성")
    void 레이싱게임생성() {
        RacingGame racingGame = new RacingGame(CarFactory.createCars(3));

        Assertions.assertThat(racingGame.getNumberOfCars()).isEqualTo(3);
    }

    @Test
    @DisplayName("라운드 실행")
    void 라운드실행() {
        RacingGame racingGame = new RacingGame(CarFactory.createCars(5));

        racingGame.runSingleRound();

        Assertions.assertThat(racingGame.getCurrentRoundCount()).isEqualTo(1);
    }
}

