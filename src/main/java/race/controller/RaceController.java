package race.controller;

import race.domain.Cars;
import race.domain.Round;
import race.view.InputView;
import race.view.ResultView;

public class RaceController {
    private final Cars cars;
    private final Round round;

    public RaceController() {
        InputView inputView = new InputView();
        String carNames = inputView.askCarNames();

        this.cars = new Cars(carNames.split(","));
        this.round = new Round(inputView.askRoundCount());
    }

    public void run() {
        ResultView resultView = new ResultView();

        for (int i = 0; i < round.getValue(); i++) {
            cars.move();
            resultView.printCurrentRoundProgress(cars);
        }

        resultView.printWinners(cars.getWinners());
    }

}
