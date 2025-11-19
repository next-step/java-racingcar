package racing.controller;

import racing.model.Cars;
import racing.model.Round;
import racing.view.ResultView;

import java.util.Random;

public class RaceController {
    private final Cars cars;
    private final Round round;
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_VALUE = 10;

    public RaceController(Cars cars, int roundCount) {
        this(cars, new Round(roundCount));
    }

    public RaceController(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void start() {
        ResultView.printResultHeader();
        while (round.isPlaying()) {
            playRound();
            round.decreaseRemainingCount();
        }
        ResultView.printWinners(cars.winners());
    }

    private void playRound() {
        cars.race(RANDOM, MAX_RANDOM_VALUE);
        ResultView.printResult(cars);
    }
}
