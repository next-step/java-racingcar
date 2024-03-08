package controller;

import model.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingController {
    public void run() {
        InputView inputView = new InputView();

        int numberOfCars = inputView.askNumberOfCars();
        int racingTurn = inputView.askRacingTurn();

        RacingGame racingGame = new RacingGame();
        racingGame.participate(numberOfCars);

        for (int i = 1; i <= racingTurn; i++) {
            racingGame.run();
        }


        ResultView resultView = new ResultView();
        resultView.print(racingGame.racingResult());
    }
}
