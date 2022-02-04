package racinggame.controller;

import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameController {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        RacingGame racingGame = new RacingGame(inputView.inputPlayerName(),
            inputView.inputTryNumber());
        racingGame.race();
        resultView.printResult(racingGame.getRoundHistories());
    }

}
