package racingCar.controller;

import racingCar.model.RacingGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingGameController {
    public void run() {
        String[] carNames = InputView.getCarNames();
        int playCount = InputView.getPlayCount();

        RacingGame racingGame = new RacingGame(carNames, playCount);
        ResultView.printCarsLocation(racingGame);
        ResultView.printWinner(racingGame);
    }
}
