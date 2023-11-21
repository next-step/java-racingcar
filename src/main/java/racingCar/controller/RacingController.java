package racingCar.controller;

import racingCar.domain.Cars;
import racingCar.domain.MovementGenerator;
import racingCar.domain.RacingManager;
import racingCar.domain.TryCount;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovementGenerator movementGenerator;

    public RacingController(InputView inputView, OutputView outputView, MovementGenerator movementGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movementGenerator = movementGenerator;
    }

    public void run() {
        Cars cars = Cars.from(inputView.inputPlayer());
        TryCount tryCount = TryCount.from(inputView.inputTryCount());

        RacingManager racingManager = new RacingManager(cars, tryCount, movementGenerator);

        playRacing(racingManager, cars);
        showWinnerGroup(cars);
    }

    private void playRacing(RacingManager racingManager, Cars cars) {
        while (racingManager.canPlay()) {
            racingManager.playTurn();
            outputView.printMovement(cars);
        }
    }

    private void showWinnerGroup(Cars cars) {
        outputView.printWinnerGroup(cars.getWinnerGroup());
    }
}
