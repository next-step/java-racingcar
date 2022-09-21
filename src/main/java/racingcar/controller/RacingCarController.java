package racingcar.controller;

import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.view.RetryView;

public class RacingCarController {
    private final RacingGame racingGame = new RacingGame();

    public void run() {
        int numberOfCars = RetryView.retryIfInputNegativeNumber(InputView::inputNumberOfCars);
        int tryCount = RetryView.retryIfInputNegativeNumber(InputView::inputTryCount);

        racingGame.join(numberOfCars);
        ResultView.printResult(racingGame.race(tryCount));
    }
}
