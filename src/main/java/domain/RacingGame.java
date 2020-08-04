package domain;

import strategy.AboveNumberMove;
import strategy.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class RacingGame {

    private static final int  MOVABLE_NUMBER = 4;

    public void start() {
        int numberOfCars = InputView.inputNumberOfCar();
        int time = InputView.inputTime();

        Cars cars = new Cars(numberOfCars, new AboveNumberMove(MOVABLE_NUMBER), new RandomNumberGenerator());

        ResultView.printResultLine();
        for (int i = 0; i < time; i++) {
            cars.race();
            ResultView.printLocations(cars.getCars());
        }
    }
}
