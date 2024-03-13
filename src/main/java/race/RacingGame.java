package race;

import race.domain.Cars;
import race.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<String> mileages = new ArrayList<>();
    private static final Random randomNumber = new Random();
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
        for (int carNumber = 0; carNumber < numberOfCars; carNumber++) {
            mileages = cars.goForward(numberOfCars, attempt, randomNumber.nextInt(10));
        }
    }

}
