package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.concurrent.ThreadLocalRandom;

public class CarRacing {
    private static final Integer MIN_NUM = 0;
    private static final Integer MAX_NUM = 10;

    public static void start() {
        InputView input = InputView.scan();

        Cars cars = Cars.of(input.carNames());

        ResultView.printStartComment();
        for (int i = 0; i < input.tryCount(); i++) {
            cars = cars.race(new RandomMovingPolicy(randomNumber()));

            ResultView.printRacing(cars);
        }
        ResultView.printWinners(cars);
    }

    private static Integer randomNumber() {
        return ThreadLocalRandom.current().nextInt(MIN_NUM, MAX_NUM);
    }
}
