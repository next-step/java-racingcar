package step3.racingCar;

import step3.racingCar.domain.Cars;
import step3.racingCar.view.InputView;
import step3.racingCar.view.ResultView;

public class RacingGame {
    public void race() {
        int numOfCars = InputView.numOfCars();
        int times = InputView.times();

        Cars cars = Cars.generateCars(numOfCars);

        ResultView.output();
        for (int i = 0; i < times; i++) {
            cars.move();
            ResultView.result(cars);
        }
    }
}


