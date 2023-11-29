package race;

import race.domain.Cars;
import race.view.InputView;
import race.view.ResultView;

public class CarRacingGame {

    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames().split(",");
        int numberOfTry = InputView.inputNumberOfTry();

        Cars cars = new Cars();
        cars.initCars(carNames);

        ResultView.printResult(cars, numberOfTry);
    }
}
