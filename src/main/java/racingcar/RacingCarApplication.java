package racingcar;

import racingcar.config.RacingCarConfig;
import racingcar.controller.RacingGame;

public class RacingCarApplication {

    public static void main(String[] args) {
        final RacingGame racingGame = RacingCarConfig.racingGame();

        racingGame.run();
    }
}
