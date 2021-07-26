package racingCar;

import racingCar.model.Cars;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class App {
    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int playCount = InputView.getPlayCount();

        Cars cars = new Cars(carCount, playCount);
        ResultView.printCars(cars);
    }
}
