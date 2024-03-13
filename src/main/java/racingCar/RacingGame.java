package racingCar;


import static view.InputView.inputNumberOfCars;
import static view.InputView.inputNumberOfTry;
import static view.ResultView.printResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public void run() {
        RacingCars cars = new RacingCars(CarFactory.createCars(inputNumberOfCars()));
        tryMove(cars, inputNumberOfTry());
    }

    private void tryMove(RacingCars cars, int numberOfTries) {
        for (int i = 0; i < numberOfTries; i++) {
            cars.moveCars();
            printResult(cars);
        }
    }

}
