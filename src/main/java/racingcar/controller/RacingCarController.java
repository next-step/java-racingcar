package racingcar.controller;

import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    private final RacingGame racingGame = new RacingGame();

    public void run() {
        int numberOfCars;
        do {
            numberOfCars = Integer.parseInt(InputView.inputNumberOfCars());
        } while (numberOfCars < 0);

        int tryCount;
        do {
            tryCount = Integer.parseInt(InputView.inputTryCount());
        } while (tryCount < 0);


        racingGame.join(numberOfCars);
        ResultView.printResult(racingGame.race(tryCount));
    }
}
