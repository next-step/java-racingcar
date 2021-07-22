package racingCar;

import racingCar.model.Cars;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class App {
    public static void main(String[] args) {
        Cars cars = InputView.start();
        ResultView.printCars(cars);
    }
}
