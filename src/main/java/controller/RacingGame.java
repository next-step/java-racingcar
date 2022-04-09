package controller;

import commons.Constant;
import exceptions.InputValueException;
import model.CarsProgress;
import view.InputView;

public class RacingGame {
    private CarsProgress carsProgress;
    private int numberOfGames;

    public void startRacingGame() {
        InputService inputService = new InputService();
        carsProgress = new CarsProgress(inputService.convertInputValue(InputView.inputNumberOfCars()));
        numberOfGames = inputService.convertInputValue(InputView.inputNumberOfAttempts());
    }
}
