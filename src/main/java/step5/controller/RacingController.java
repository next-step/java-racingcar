package step5.controller;

import step5.domain.RacingGame;
import step5.strategy.MovableStrategy;
import step5.strategy.RandomMovableStrategy;
import step5.view.InputView;
import step5.view.ResultView;

public class RacingController {

    public void racingGame() {

        /* input */
        InputView inputView = new InputView();
        String[] cars = inputView.inputNamesSplittedByComma();
        int countRound = inputView.inputCountRound();
        inputView.close();

        /* strategy */
        MovableStrategy movableStrategy = new RandomMovableStrategy();
        RacingGame racingGame = new RacingGame(cars, movableStrategy);

        /* race and output */
        ResultView resultView = new ResultView();
        resultView.printResultTitle();
        for (int i = 0; i < countRound; i++) {
            racingGame.raceCars(racingGame);
            resultView.printRacingCars(racingGame);
        }
        resultView.printWinner(racingGame);
    }

}
