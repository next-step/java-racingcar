package race;

import race.domain.Cars;
import race.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<String> mileages = new ArrayList<>();
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void start(int numberOfCars, int numberOfAttempts) {
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            saveMileages(cars, numberOfCars, attempt);
            OutputView.printMileages(numberOfCars, mileages);
            OutputView.printNextLine();
        }
    }

    private void saveMileages(Cars cars, int numberOfCars, int attempt) {
        mileages = cars.goForward(numberOfCars, attempt);
    }

}
