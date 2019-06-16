package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    public void run() {
        int numberOfCars = InputView.inputNumberOfCars();
        int numberOfTries = InputView.inputNumberOfTries();

        Cars cars = new Cars(numberOfCars);

        OutputView.printResultMessage();

        for (int i = 0; i < numberOfTries; i++) {
            List<Integer> positions = cars.move();
            OutputView.printCarPositions(positions);
        }
    }
}
