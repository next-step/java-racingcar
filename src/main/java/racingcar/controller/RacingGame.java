package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private RacingCarProgressService racingCarProgressService = new RacingCarProgressService();
    private int numberOfGames;

    public void startRacingGame() {
        racingCarProgressService.createCars(InputView.inputNumberOfCars());
        numberOfGames = InputView.inputNumberOfAttempts();

        racingCarProgress();
    }

    private void racingCarProgress() {
        for (int i = 0; i < numberOfGames; i++) {
            movingCars();
        }
    }

    private void movingCars() {
        List<Car> cars = racingCarProgressService.getCarsList();
        for (Car car : cars) {
            racingCarProgressService.changeDistanceByCar(car, getRandomValue());
        }

        OutputView.printCarRacingIntermediateState(cars);
    }

    private int getRandomValue() {
        return racingCarProgressService.getRandomValue();
    }
}
