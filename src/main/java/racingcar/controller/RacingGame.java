package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.utils.RandomMovement;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarName();
        Cars cars = new Cars(carNames);
        Race race = new Race(cars, new RandomMovement());
        int racingCount = InputView.getRacingCount();

        ResultView.printMessage();
        for (int i = 0; i < racingCount; i++) {
            race.run();
            ResultView.printResult(cars);
        }
        ResultView.printWinners(cars);
    }
}
