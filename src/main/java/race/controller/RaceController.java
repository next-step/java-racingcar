package race.controller;

import race.domain.Cars;
import race.domain.Round;
import race.view.InputView;
import race.view.ResultView;

import java.util.Random;

public class RaceController {
    private final Cars cars;
    private final Round round;
    private final Random random;

    public RaceController() {
        InputView inputView = new InputView();
        String carNames = inputView.askCarNames();

        this.cars = new Cars(carNames.split(","));
        this.round = new Round(inputView.askRoundCount());
        this.random = new Random();
    }

    public void run() {
        ResultView resultView = new ResultView();

        for (int i = 0; i < round.getValue(); i++) {
            cars.move(random.nextInt());
            resultView.printCurrentRoundProgress(cars);
        }

        resultView.printWinners(cars.getWinners());
    }

}
