package controller;

import domain.Cars;
import view.InputView;

public class CarRacingController {
    private static final String RESULT_MESSAGE = "실행 결과";
    private final InputView inputView;

    public CarRacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void runRacingCar() {
        int carCount = inputView.inputCarCount();
        int attemptCount = inputView.inputAttemptCount();
        Cars cars = new Cars(carCount);

        printResultMessage();
        startRacing(attemptCount, cars);
    }

    private void startRacing(int attemptCount, Cars cars) {
        for (int i = 0; i < attemptCount; i++) {
            cars.moveCars();
            cars.printCarsPosition();
            System.out.println();
        }
    }

    private void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}
