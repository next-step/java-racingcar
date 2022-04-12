package controller;

import domain.Cars;
import view.InputView;
import view.ResultView;

public class CarRacingController {
    private static final String NEW_LINE = "\n";
    private final StringBuilder racingResult = new StringBuilder();
    private final InputView inputView;
    private final ResultView resultView;

    public CarRacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void runRacingCar() {
        initRacingResult();
        int carCount = inputView.inputCarCount();
        int attemptCount = inputView.inputAttemptCount();
        startRacing(attemptCount, new Cars(carCount));
    }

    private void initRacingResult() {
        racingResult.setLength(0);
    }

    private void startRacing(int attemptCount, Cars cars) {
        resultView.printResultHeader();
        for (int i = 0; i < attemptCount; i++) {
            cars.moveCars();
            resultView.printResult(cars.getCarsPosition());
        }
    }
}
