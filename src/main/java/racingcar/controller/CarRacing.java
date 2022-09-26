package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class CarRacing {

    public static void start() {
        InputView input = InputView.scan();

        Cars cars = Cars.of(input.carNames());

        ResultView.printStartComment();
        for (int i = 0; i < input.tryCount(); i++) {
            cars = cars.race(new RandomMovingPolicy());

            ResultView.printRacing(cars);
        }
        ResultView.printWinners(cars);
    }
}
