package domain;

import view.InputView;
import view.ResultView;

public class RacingGame {

    public void start() {
        int numberOfCars = InputView.inputNumberOfCar();
        int time = InputView.inputTime();

        Cars cars = new Cars(numberOfCars);

        ResultView.printResultLine();
        for (int i = 0; i < time; i++) {
            cars.race();
            ResultView.printLocations(cars.getCars());
        }
    }
}
