package racingcar.car.controller;

import racingcar.car.domain.Cars;
import racingcar.car.domain.MoveStrategy;
import racingcar.car.domain.RandomMoveStrategy;
import racingcar.car.view.InputView;
import racingcar.car.view.OutputView;

public class CarGameController {

    private final MoveStrategy moveStrategy;

    public CarGameController() {
        this(new RandomMoveStrategy());
    }

    public CarGameController(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        final Cars cars = new Cars(InputView.getCarNames());
        final int playCount = InputView.getPlayCount();
        race(cars, playCount);
        printResult(cars);
    }

    private void race(Cars cars, int playCount) {
        for (int i = 0; i < playCount; i++) {
            cars.move(moveStrategy);
            OutputView.printStatus(cars.getCars());
        }
    }

    private void printResult(Cars cars) {
        OutputView.printResult(cars.getWinners());
    }
}
