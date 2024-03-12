package race;

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

    public List<String> goForward(int numberOfCars, int numberOfAttempts, int randomNumber) {
        List<String> mileages = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.get(i).go(numberOfAttempts, randomNumber);
            mileages.add(this.cars.get(i).getMileage());
        }
        return mileages;
    }

}
