package race.controller;

import race.domain.Cars;
import race.view.InputView;
import race.view.ResultView;

import java.util.Random;

public class RaceController {
    private final Cars cars;
    private final int round;
    private final Random random;
    private final ResultView resultView;

    public RaceController(Random random, InputView inputView, ResultView resultView) {
        String carNames = inputView.askCarNames();
        this.cars = new Cars(carNames.split(","));
        this.round = inputView.askRoundCount();
        this.random = random;
        this.resultView = resultView;
    }

    public void run() {
        for (int i = 0; i < round; i++) {
            cars.move(random.nextInt());
            resultView.printCurrentRoundProgress(cars);
        }

        resultView.printWinners(cars.getWinners());
    }

}
