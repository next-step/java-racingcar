package racingCar.controller;

import java.util.List;
import racingCar.domain.Car;
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
        while (racingManager.canPlay()) {
            racingManager.playTurn();
            outputView.printMovement(carGroup);
        }
        outputView.printWinnerGroup(carGroup.getWinnerGroup());
    }
}
