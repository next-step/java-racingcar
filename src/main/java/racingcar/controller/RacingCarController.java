package racingcar.controller;

import racingcar.repository.RacingCarTable;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.view.RetryView;

public class RacingCarController {
    private final RacingGame racingGame = new RacingGame(new RacingCarTable());

    public void run() {
        String carNames = RetryView.retryIfNotValidNames(InputView::inputCarNames);
        int tryCount = RetryView.retryIfNotValidNumber(InputView::inputTryCount);

        racingGame.join(carNames);
        ResultView.printResult(racingGame.race(tryCount));
    }
}
