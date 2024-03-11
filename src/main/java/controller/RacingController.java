package controller;

import model.Car;
import model.RacingGame;
import model.RacingRecord;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingController {
    public void run() {
        InputView inputView = new InputView();

        List<Car> cars = inputView.askCarNames();
        int racingTurn = inputView.askRacingTurn();

        RacingGame racingGame = new RacingGame(cars);
        RacingRecord racingRecord = racingGame.run(racingTurn);
        racingRecord.saveWinners(racingGame.winnerNames());

        ResultView resultView = new ResultView(racingRecord);
        resultView.draw();
        resultView.print();
    }
}
