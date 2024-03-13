package race.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int numberOfCars) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public List<String> goForward(int numberOfCars, int numberOfAttempts) {
        return goRandomForward(numberOfCars, numberOfAttempts);
    }

    private List<String> goRandomForward(int numberOfCars, int numberOfAttempts) {
        List<String> mileages = new ArrayList<>();
        for (int carNumber = 0; carNumber < numberOfCars; carNumber++) {
            this.cars.get(carNumber).go(numberOfAttempts);
            mileages.add(this.cars.get(carNumber).getMileage());
        }
        return mileages;
    }

}
