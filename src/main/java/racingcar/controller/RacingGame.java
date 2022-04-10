package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private RacingCarProgressService racingCarProgressService = new RacingCarProgressService();
    private int numberOfGames;

    public void startRacingGame() {
        InputService inputService = new InputService();
        racingCarProgressService.createCars(inputService.convertInputValue(InputView.inputNumberOfCars()));
        numberOfGames = inputService.convertInputValue(InputView.inputNumberOfAttempts());

        racingCarProgress();
    }

    private void racingCarProgress() {
        for (int i = 0; i < numberOfGames; i++) {
            movingCars();
        }
    }

    private void movingCars() {
        List<Cars> carsList = racingCarProgressService.getCarsList();
        for (Cars cars : carsList) {
            racingCarProgressService.changeDistanceByCar(cars, getRandomValue());
        }

        OutputView.printCarRacingIntermediateState(carsList);
    }

    private int getRandomValue() {
        return racingCarProgressService.getRandomValue();
    }
}
