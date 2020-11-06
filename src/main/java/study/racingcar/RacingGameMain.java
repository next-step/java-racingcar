package study.racingcar;

import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class RacingGameMain {

    public static void main(String[] args) {
        GameConfiguration gameConfiguration = InputView.initGameWithOldEngine();
        RacingGame racingGame = new RacingGame(gameConfiguration, ResultView.getInstance());
        racingGame.startGame();
    }
}
