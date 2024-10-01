package step3.controller;

import step3.model.Cars;
import step3.view.InputView;
import step3.view.OutputView;

public class RacingCarController {
    public RacingCarController() {
    }

    public void racing() {
        String carNames = InputView.getCarNames();
        Cars cars = Cars.from(carNames);

        int tryCount = InputView.getTryCount();
        OutputView.printRacingResult();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            OutputView.printRacingProgress(cars);
        }
    }
}
