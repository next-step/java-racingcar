package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("라운드 실행")
    void 라운드실행() {
        RacingGame racingGame = new RacingGame(CarFactory.createCars("bmw,benz"));

        racingGame.runSingleRound();

        Assertions.assertThat(racingGame.getCurrentRoundCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자조회")
    void 우승자조회() {
        Car[] cars = CarFactory.createCars("bmw,benz,tesla");

        // 우승자는 benz,hyundai
        cars[0].moveForwardOrStop(4);
        cars[1].moveForwardOrStop(4);
        cars[1].moveForwardOrStop(4);
        cars[2].moveForwardOrStop(4);
        cars[2].moveForwardOrStop(4);

        RacingGame racingGame = new RacingGame(cars);

        Assertions.assertThat(racingGame.getWinners()).contains(new String[]{"benz","tesla"});
    }
}

