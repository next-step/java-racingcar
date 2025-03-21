package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.view.ResultView;

public class RacingGameController {

    private final Cars cars;
    private final int tryCount;
    private final ResultView resultView;

    public RacingGameController(Cars cars, int tryCount, ResultView resultView) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.resultView = resultView;
    }

    public void process(MoveStrategy moveStrategy) {
        resultView.printResult();
        for (int i = 0; i < tryCount; i++) {
            moveCars(this.cars, moveStrategy);
            resultView.printCars(this.cars);
        }
        resultView.printWinners(cars);
    }

    private void moveCars(Cars cars, MoveStrategy moveStrategy) {
        cars.moveAll(moveStrategy);
    }
}
