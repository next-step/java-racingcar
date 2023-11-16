package carracing.controller;

import carracing.domain.car.Cars;
import carracing.domain.car.Winners;
import carracing.domain.game.*;
import carracing.view.InputView;
import carracing.view.ResultView;

public class RacingGameController {
    public void race() {
        Cars racingCars = InputView.inputCars();
        int tryingTimes = InputView.inputTryingNumber();
        RacingGame racingGame = new RacingGame(racingCars, tryingTimes);
        MovingStrategy movingStrategy = new RandomRange(0, 9);

        for (int i = 0; i < tryingTimes; i++) {
            racingGame.race(movingStrategy);
            ResultView.printMovingResult(racingCars);
        }

        ResultView.printResultPhrase();
        WinnerStrategy maxMoving = new MaxMoving();
        Winners winners = racingCars.winners(maxMoving);
        ResultView.printWinners(winners);
    }
}
