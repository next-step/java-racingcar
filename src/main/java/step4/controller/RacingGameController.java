package step4.controller;

import step4.domain.RacingGame;
import step4.view.InputView;
import step4.view.ResultView;

public class RacingGameController {

    private InputView inputView;
    private ResultView resultView;
    private RacingGame racingGame;

    public RacingGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.racingGame = new RacingGame();
    }

    private void enterGameParameters() {
        this.racingGame.initialize(inputView.enterCarNames(), inputView.enterTryCount());
    }

    private void getWinners() {
        this.racingGame.chooseWinners();
        this.resultView.printWinners(racingGame.getWinners());
    }

    public void launchGame() {
        enterGameParameters();

        resultView.printResultTitle();
        for (int i = 0; i < racingGame.getTryCount(); ++i) {
            racingGame.goCars();
            resultView.printCurrentResult(racingGame.getCars());
        }

        getWinners();
    }
}
