package racingCar.controller;

import racingCar.domain.CarGroup;
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
        CarGroup carGroup = CarGroup.from(inputView.inputPlayer());
        TryCount tryCount = TryCount.from(inputView.inputTryCount());

        RacingManager racingManager = new RacingManager(carGroup, tryCount, movementGenerator);

        playRacing(racingManager, carGroup);
        showWinnerGroup(carGroup);
    }

    private void playRacing(RacingManager racingManager, CarGroup carGroup) {
        while (racingManager.canPlay()) {
            racingManager.playTurn();
            outputView.printMovement(carGroup);
        }
    }

    private void showWinnerGroup(CarGroup carGroup) {
        outputView.printWinnerGroup(carGroup.getWinnerGroup());
    }
}
