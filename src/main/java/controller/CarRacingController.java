package controller;

import domain.Cars;
import view.InputView;
import view.ResultView;

public class CarRacingController {
    private final InputView inputView = InputView.getInstance();
    private final ResultView resultView = ResultView.getInstance();

    public void startRacing() {
        int carCount = inputView.inputCarCount();
        int attemptCount = inputView.inputAttemptCount();
        runCars(attemptCount, new Cars(carCount));
    }

    private void runCars(int attemptCount, Cars cars) {
        resultView.printResultHeader();
        for (int i = 0; i < attemptCount; i++) {
            cars.moveCars();
            resultView.printResult(cars.getCarsPosition());
        }
    }
}
