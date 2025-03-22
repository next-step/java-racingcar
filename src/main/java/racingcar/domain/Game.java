package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Random;

public class Game {
    private final InputView inputView;
    private final ResultView resultView;
    private final Random random;
    private final Tracker tracker;

    private Cars cars;


    public Game(InputView inputView, ResultView resultView, Random random, Tracker tracker) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.random = random;
        this.tracker = tracker;

        this.postConstruct();
    }

    private void postConstruct() {
        List<String> carNames = inputView.getValidCarNames();
        cars = CarFactory.create(carNames);
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
            cars.race(random);
            tracker.saveRecords(this.cars);
        }
    }
}
