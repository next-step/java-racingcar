package step5.controller;

import step5.domain.RacingGame;
import step5.view.InputView;
import step5.view.ResultView;

public class RacingController {

    public void racingGame() {
        InputView inputView = new InputView();

        String[] cars = inputView.inputNamesSplittedByComma();
        int countRound = inputView.inputCountRound();

        inputView.close();

        RacingGame racingGame = new RacingGame(cars);

        ResultView resultView = new ResultView();

        resultView.printResultTitle();

        for (int i = 0; i < countRound; i++) {
            racingGame.raceCars(racingGame);
            resultView.printRacingCars(racingGame);
        }

        resultView.printWinner(racingGame);
    }

}
