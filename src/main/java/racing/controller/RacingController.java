package racing.controller;

import racing.domain.Cars;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {

    public static void startRacing() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String[] carNames = inputView.inputCarNames();
        int attemptCount = inputView.inputAttemptCount();

        Cars cars = Cars.createCars(carNames);

        resultView.resultMessage();
        for (int i = 0; i < attemptCount; i++) {
            cars.tryMove();
            resultView.carStatus(cars);
        }

        resultView.showWinner(cars.findWinners());
    }
}
