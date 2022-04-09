package controller;

import commons.Constant;
import exceptions.InputValueException;
import model.CarsProgress;
import view.InputView;

public class RacingGame {
    private CarsProgress carsProgress;
    private int numberOfGames;

    public void startRacingGame() {
        carsProgress = new CarsProgress(validationInputValue(InputView.inputNumberOfCars()));
        numberOfGames = Integer.parseInt(validationInputValue(InputView.inputNumberOfAttempts()));
    }

    public String validationInputValue(String numberOfCarsString) throws InputValueException {
        if (!numberOfCarsString.matches(Constant.NUMERIC_REGEX)) {
            throw new RuntimeException(Constant.NON_NUMERIC_ERR_MSG);
        }

        if (!numberOfCarsString.matches(Constant.POSITIVE_INTEGER_REGEX)) {
            throw new RuntimeException(Constant.ZERO_OR_NEGATIVE_NUMERIC_ERR_MSG);
        }

        return numberOfCarsString;
    }
}
