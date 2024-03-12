package race;

import race.domain.Cars;
import race.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<String> mileages = new ArrayList<>();
    private int randomNumber =  new Random().nextInt(10);
    private Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void start(int numberOfCars, int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            saveMileages(cars, numberOfCars, i);
            OutputView.printMileages(numberOfCars, mileages);
            OutputView.printNextLine();
        }
    }

    private void saveMileages(Cars cars, int numberOfCars, int i) {
        for (int j = 0; j < numberOfCars; j++) {
            mileages = cars.goForward(numberOfCars, i, randomNumber);
        }
    }

}
