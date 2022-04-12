package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.PositionControl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars;

    public void startRacingGame() {
        cars = new Cars(InputView.inputNumberOfCars());
        int numberOfGames = InputView.inputNumberOfAttempts();
        progressNumberOfGames(numberOfGames);
    }

    private void progressNumberOfGames(int numberOfGames) {
        OutputView.printCarRacingResult();
        for (int i = 0; i < numberOfGames; i++) {
            carMovementByRound();
        }
    }

    private void carMovementByRound() {
        PositionControl positionControl = new PositionControl();
        for (Car car : cars.getCars()) {
            car.move();
        }

        OutputView.printCarRacingIntermediateState(cars);
    }
}
