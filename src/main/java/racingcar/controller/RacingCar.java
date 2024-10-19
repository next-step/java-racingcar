package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCar {
    public static void main(String[] args) {
        Cars cars = Cars.fromCarNames(InputView.inputCarNames());
        ResultView.printRaceResults(cars.runRace(InputView.inputLoop()));
        ResultView.printWinners(cars.getWinners());
    }
}
