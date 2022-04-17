package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.factory.CarsFactory;
import racingcar.view.OutputView;

public class RacingGame {
    private final String carNames;
    private final int carMoveCount;

    public RacingGame(String carNames, int carMoveCount) {
        this.carNames = carNames;
        this.carMoveCount = carMoveCount;
    }

    public void start() {
        Cars cars = CarsFactory.create(carNames);

        for (int i = 0; i < carMoveCount; i++) {
            cars.move();
            OutputView.outputStatus(cars);
        }

        Cars winnerCars = cars.findWinners();
        OutputView.outputWinners(winnerCars);
    }
}
