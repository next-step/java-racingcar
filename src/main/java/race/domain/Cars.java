package race.domain;

import race.RaceRule;
import race.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private final List<Car> cars;

    public Cars(int numberOfCars) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public List<String> goForward(int numberOfCars, int numberOfAttempts, int randomNumber) {
        return goRandomForward(numberOfCars, numberOfAttempts, randomNumber);
    }

    private List<String> goRandomForward(int numberOfCars, int numberOfAttempts, int randomNumber) {
        List<String> mileages = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.get(i).go(numberOfAttempts, randomNumber);
            mileages.add(this.cars.get(i).getMileage());
        }
        return mileages;
    }

}
