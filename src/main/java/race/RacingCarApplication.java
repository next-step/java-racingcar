package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import race.domain.Car;
import race.domain.Cars;
import race.view.InputView;
import race.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        int numberOfCar = InputView.requestCars();
        int countOfTrial = InputView.requestCountOfTrial();
        ResultView.start();
        Cars cars = Cars.createInstance(numberOfCar);
        racing(cars, countOfTrial);
    }

    private static void racing(Cars cars, int countOfTrial) {
        for (int i = 0; i < countOfTrial; i++) {
            cars.moveCars();
            ResultView.showProcess(cars);
        }
    }
}
