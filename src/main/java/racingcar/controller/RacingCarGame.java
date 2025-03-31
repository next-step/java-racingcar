package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.carMover.NumberBasedCarMover;
import racingcar.domain.carMover.RandomNumberBasedCarMover;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {
    private TryCount tryCount;
    private Cars cars;

    public RacingCarGame(TryCount tryCount, Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void startGame(TryCount tryCount, Cars cars, NumberBasedCarMover carMover) {
        game(cars, tryCount, carMover);
        printGameResult(cars);
    }

    private Cars inputCars() {
        return new Cars(InputView.inputCarNames());
    }

    private TryCount inputTryCount() {
        return new TryCount(InputView.inputTryCount());
    }

    private void game(Cars cars, TryCount tryCount, NumberBasedCarMover carMover) {
        int currentTryCount = 0;
        ResultView.printResultMessage();
        while (tryCount.isNotSame(currentTryCount++)) {
            cars.moveAll(carMover);
            ResultView.printCarsPosition(cars.cars());
        }
    }

    private void printGameResult(Cars cars) {
        ResultView.printCarsPosition(cars.cars());
        ResultView.printWinners(cars.winners());
    }
}
