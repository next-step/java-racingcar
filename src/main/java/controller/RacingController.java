package controller;

import model.RacingGame;
import view.InputView;
import view.ResultView;

public class RacingController {
    public void run() {
        InputView inputView = new InputView();

        int numberOfCars = inputView.askNumberOfCars();
        int racingTurn = inputView.askRacingTurn();

        RacingGame racingGame = new RacingGame(numberOfCars);
        ResultView resultView = racingGame.run(racingTurn);
        resultView.print();
    }
}
