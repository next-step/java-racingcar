package racingcar.controller;

import racingcar.view.InputView;

public class RacingGame {
    private RacingCarProgressService racingCarProgressService = new RacingCarProgressService();
    private int numberOfGames;

    public void startRacingGame() {
        InputService inputService = new InputService();
        racingCarProgressService.createCars(inputService.convertInputValue(InputView.inputNumberOfCars()));
        numberOfGames = inputService.convertInputValue(InputView.inputNumberOfAttempts());

    }

    private int getRandomValue() {
        return racingCarProgressService.getRandomValue();
    }
}
