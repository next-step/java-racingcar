package step5;

import step5.controller.RacingGameController;
import step5.domain.RacingGame;
import step5.domain.RandomNumberStrategy;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarApplication.run();
    }

    public static void run() {
        final RacingGameController racingGameController = new RacingGameController();
        final String[] carNames = racingGameController.inputCarNames();
        final int tryCount = racingGameController.inputTryCount();
        final RacingGame racingGame = racingGameController.makeRacingGame(carNames, tryCount, new RandomNumberStrategy());
        racingGameController.play(racingGame);
    }
}
