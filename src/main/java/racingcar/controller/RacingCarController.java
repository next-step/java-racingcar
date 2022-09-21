package racingcar.controller;

import racingcar.service.RacingGame;
import racingcar.util.InputIntegerRetry;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    private final RacingGame racingGame = new RacingGame();

    public void run() {
        int numberOfCars = InputIntegerRetry.retry(InputView::inputNumberOfCars);
        int tryCount = InputIntegerRetry.retry(InputView::inputTryCount);

        racingGame.join(numberOfCars);
        ResultView.printResult(racingGame.race(tryCount));
    }
}
