package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarFactory;
import racingcar.domain.RacingGame;

public class RacingGameTest {

    @Test
    @DisplayName("라운드 실행")
    void 라운드실행() {
        RacingGame racingGame = new RacingGame(CarFactory.createCars(5));

        racingGame.runSingleRound();

        Assertions.assertThat(racingGame.getCurrentRoundCount()).isEqualTo(1);
    }
}

