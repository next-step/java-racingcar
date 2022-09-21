package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.RaceGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {

    public void run() {
        int numberOfCars;
        do {
            numberOfCars = Integer.parseInt(InputView.inputNumberOfCars());
        } while (numberOfCars < 0);

        int tryCount;
        do {
            tryCount = Integer.parseInt(InputView.inputTryCount());
        } while (tryCount < 0);

        Cars cars = CarFactory.createCars(numberOfCars);
        RaceGame game = new RaceGame(cars);

        ResultView.printResult();
        for (int i = 0; i < tryCount; i++) {
            game.race();
            ResultView.printGameStatus(game);
        }
    }
}
