package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.factory.CarsFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        int carCount = InputView.inputCarCount();
        int carMoveCount = InputView.inputCarMoveCount();

        Cars cars = CarsFactory.create(carCount);

        for (int i = 0; i < carMoveCount; i++) {
            cars.move();
            OutputView.outputPosition(cars.getAllPositions());
        }
    }
}
