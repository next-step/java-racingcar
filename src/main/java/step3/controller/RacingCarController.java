package step3.controller;

import step3.model.Cars;
import step3.view.InputView;
import step3.view.OutputView;

public class RacingCarController {
    public RacingCarController() {
    }

    public void racing() {
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();

        Cars cars = Cars.from(carCount);
        OutputView.printRacingResult();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            OutputView.printRacingProgress(cars);
        }
    }
}
