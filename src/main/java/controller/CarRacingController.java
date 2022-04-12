package controller;

import domain.Cars;
import view.InputView;
import view.ResultView;

public class CarRacingController {
    private final InputView inputView;
    private final ResultView resultView;

    public CarRacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void runRacingCar() {
        int carCount = inputView.inputCarCount();
        int attemptCount = inputView.inputAttemptCount();
        startRacing(attemptCount, new Cars(carCount));
    }

    private void startRacing(int attemptCount, Cars cars) {
        resultView.printResultHeader();
        for (int i = 0; i < attemptCount; i++) {
            cars.moveCars();
            resultView.printResult(cars.getCarsPosition());
        }
    }
}
