package racingcar.controller;

import racingcar.repository.RacingCarTable;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.view.RetryView;

public class RacingCarController {
    private final RacingGame racingGame = new RacingGame(new RacingCarTable());

    public void run() {
        int numberOfCars = RetryView.retryIfNotValidNumber(InputView::inputNumberOfCars);
        int tryCount = RetryView.retryIfNotValidNumber(InputView::inputTryCount);

        racingGame.join(numberOfCars);
        ResultView.printResult(racingGame.race(tryCount));
    }
}
