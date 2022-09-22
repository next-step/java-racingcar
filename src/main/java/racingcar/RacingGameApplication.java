package racingcar;

import racingcar.domain.RacingGame;

import static racingcar.view.InputView.inputCarCount;
import static racingcar.view.InputView.inputTrial;
import static racingcar.view.ResultView.printGameResult;

public class RacingGameApplication {
    public static void main(String[] args) {
        int carCount = inputCarCount();
        int trial = inputTrial();

        RacingGame racingGame = new RacingGame();
        racingGame.startGame(carCount, trial);
        printGameResult(racingGame.getRoundResults());
    }
}
