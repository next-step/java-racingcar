package racingcar.controller;

import racingcar.model.CarsProgress;
import racingcar.view.InputView;

public class RacingGame {
    private CarsProgress carsProgress;
    private int numberOfGames;

    public void startRacingGame() {
        InputService inputService = new InputService();
        carsProgress = new CarsProgress(inputService.convertInputValue(InputView.inputNumberOfCars()));
        numberOfGames = inputService.convertInputValue(InputView.inputNumberOfAttempts());
    }
}
