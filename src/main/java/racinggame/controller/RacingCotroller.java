package racinggame.controller;

import racinggame.domain.RacingGame;
import racinggame.domain.RandomMovingStrategy;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingCotroller {
    public void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        RacingGame racingGame = new RacingGame(inputView.inputCarsName(), inputView.inputTryCount());
        resultView.printResultMessage();
        while (racingGame.getTryCount() > 0) {
            resultView.printResul(racingGame, randomMovingStrategy);
        }
        resultView.printWinner(racingGame);
    }
}
