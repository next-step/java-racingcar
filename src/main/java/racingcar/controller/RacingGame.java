package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.factory.CarsFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        String carNames = InputView.inputCarNames();
        int carMoveCount = InputView.inputCarMoveCount();

        Cars cars = CarsFactory.create(carNames);

        for (int i = 0; i < carMoveCount; i++) {
            cars.move();
            OutputView.outputPosition(cars.getAllPositions());
        }
    }
}
