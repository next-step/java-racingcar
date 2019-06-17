package racingcar.controller;

import racingcar.model.CarInformation;
import racingcar.model.Cars;
import racingcar.model.Position;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class RacingGame {
    public boolean run() {
        List<String> carNames;
        int numberOfTries;

        try {
            carNames = InputView.inputCarNames();
            numberOfTries = InputView.inputNumberOfTries();
        } catch (InputMismatchException exception) {
            return false;
        }

        Cars cars = new Cars(carNames);
        OutputView.printResultMessage();
        for (int i = 0; i < numberOfTries; i++) {
            List<CarInformation> informationList = cars.move();
            OutputView.printCars(informationList);
        }

        return true;
    }
}
