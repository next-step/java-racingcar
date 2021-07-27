package racingCar;

import racingCar.model.Cars;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class App {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int playCount = InputView.getPlayCount();

        Cars cars = new Cars(carNames, playCount);
        ResultView.printCars(cars);
    }
}
