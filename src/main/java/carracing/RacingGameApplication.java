package carracing;

import carracing.controller.RacingGameController;
import carracing.domain.car.Cars;
import carracing.domain.game.*;
import carracing.view.InputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        Cars cars = InputView.inputCars();
        int tryingTimes = InputView.inputTryingNumber();
        RacingGame racingGame = new RacingGame(cars, tryingTimes);
        MovingStrategy movingStrategy = new RandomRange(0, 9);
        WinnerStrategy winnerStrategy = new MaxMoving();

        RacingGameController racingGameController = new RacingGameController();
        racingGameController.start(racingGame, movingStrategy, winnerStrategy);
    }
}
