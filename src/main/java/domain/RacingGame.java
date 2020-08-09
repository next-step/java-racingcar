package domain;

import strategy.AboveNumberMove;
import strategy.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.Set;

public class RacingGame {

    private static final int  MOVABLE_NUMBER = 4;

    public void start() {
        Set<String> numberOfCars = InputView.inputNumberOfCar();
        int time = InputView.inputTime();

        Cars cars = new Cars(numberOfCars, new AboveNumberMove(MOVABLE_NUMBER, new RandomNumberGenerator()));

        ResultView.printResultLine();
        for (int i = 0; i < time; i++) {
            ResultView.printLocations(cars.race());
        }
        ResultView.printWinners(cars);
    }
}
