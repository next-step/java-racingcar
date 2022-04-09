package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.factory.CarsFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        InputView inputView = new InputView();

        int carCount = inputView.inputCarCount();
        int carMoveCount = inputView.inputCarMoveCount();

        OutputView outputView = new OutputView();

        Cars cars = CarsFactory.create(carCount);
        outputView.outputMoveCar(cars, carMoveCount);
    }
}
