package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class RacingGame {
    public boolean run() {
        int numberOfCars, numberOfTries;

        try {
            numberOfCars = InputView.inputNumberOfCars();
            numberOfTries = InputView.inputNumberOfTries();
        } catch (InputMismatchException exception) {
            return false;
        }

        Cars cars = new Cars(numberOfCars);
        OutputView.printResultMessage();
        for (int i = 0; i < numberOfTries; i++) {
            List<Integer> positions = cars.move();
            OutputView.printCarPositions(positions);
        }

        return true;
    }
}
