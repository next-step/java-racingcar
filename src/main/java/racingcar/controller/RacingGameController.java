package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGame racingGame = new RacingGame(inputView.inputCarNames(),
            inputView.inputTryCount());
        outputView.printResult(racingGame.startRace());
        Winner winner = new Winner(racingGame.getFinalRoundResult());
        outputView.printWinner(winner.findWinner());
    }
}
