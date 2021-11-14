package study.racing.model;

import study.racing.model.car.RacingCars;
import study.racing.model.rule.Rule;
import study.racing.ui.InputView;
import study.racing.ui.ResultView;

public class RacingGame {

    private final Rule rule;

    public RacingGame(Rule rule) {
        this.rule = rule;
    }

    public void start() {
        int carCount = InputView.acceptCarCount();
        int tryCount = InputView.acceptTryCount();

        RacingCars racingCars = new RacingCars(carCount);
        for (int i = 0; i < tryCount; i++) {
            racingCars.race(rule);
            ResultView.printResult(racingCars.result());
        }
    }
}
