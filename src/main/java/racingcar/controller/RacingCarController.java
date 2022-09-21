package racingcar.controller;

import racingcar.service.RacingGame;
import racingcar.util.InputViewUtil;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    private final RacingGame racingGame = new RacingGame();

    public void run() {
        int numberOfCars = InputViewUtil.inputPositiveInt(InputView::inputNumberOfCars);
        int tryCount = InputViewUtil.inputPositiveInt(InputView::inputTryCount);

        racingGame.join(numberOfCars);
        ResultView.printResult(racingGame.race(tryCount));
    }
}
