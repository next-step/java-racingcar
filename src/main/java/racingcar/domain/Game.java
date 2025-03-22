package racingcar.domain;

import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class Game {
    private final InputView inputView;
    private final ResultView resultView;
    private final Tracker tracker;
    private final MovingStrategy strategy;

    private Cars cars;

    public Game(InputView inputView, ResultView resultView, Tracker tracker, MovingStrategy strategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.tracker = tracker;
        this.strategy = strategy;

        this.postConstruct();
    }

    private void postConstruct() {
        List<String> carNames = inputView.getValidCarNames();
        cars = CarFactory.create(carNames, strategy);
    }

    public void start() {
        int attempts = inputView.getAttempts();
        this.race(attempts);
    }

    public void finish() {
        this.resultView.printResult(tracker.findAllRecords());
        this.resultView.printWinners(tracker.findWinnerRecords());
    }

    private void race(int attempts) {
        for (int i = 0; i < attempts; i++) {
            cars.race();
            tracker.saveRecords(this.cars);
        }
    }
}
