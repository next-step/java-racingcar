package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.RaceGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {

    public void run() {
        int numberOfCars = Integer.parseInt(InputView.inputNumberOfCars());
        int tryCount = Integer.parseInt(InputView.inputTryCount());

        Cars cars = CarFactory.createCars(numberOfCars);
        RaceGame game = new RaceGame(cars);

        ResultView.printResult();
        for (int i = 0; i < tryCount; i++) {
            game.race();
            ResultView.printGameStatus(game);
        }
    }
}
