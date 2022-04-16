package controller;

import domain.Cars;
import util.MoveStrategy;
import view.InputView;
import view.ResultView;

public class CarRacingController {
    private final InputView inputView;
    private final ResultView resultView;
    private final MoveStrategy moveStrategy;

    public CarRacingController(InputView inputView, ResultView resultView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.moveStrategy = moveStrategy;
    }

    public void startRacing() {
        int carCount = inputView.inputCarCount();
        int attemptCount = inputView.inputAttemptCount();
        runCars(attemptCount, new Cars(carCount));
    }

    private void runCars(int attemptCount, Cars cars) {
        resultView.printResultHeader();
        for (int i = 0; i < attemptCount; i++) {
            cars.moveCars(moveStrategy);
            resultView.printResult(cars.getCarsPosition());
        }
    }
}
