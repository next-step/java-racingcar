package controller;

import model.RacingGame;
import model.RacingRecord;
import view.InputView;
import view.ResultView;

public class RacingController {
    public void run() {
        InputView inputView = new InputView();

        int numberOfCars = inputView.askNumberOfCars();
        int racingTurn = inputView.askRacingTurn();

        RacingGame racingGame = new RacingGame(numberOfCars);
        RacingRecord racingRecord = racingGame.run(racingTurn);

        ResultView resultView = new ResultView();
        resultView.draw(racingTurn, racingRecord);
        resultView.print();
    }
}
