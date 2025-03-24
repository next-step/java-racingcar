package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int numberOfCars) {
        generateCars(numberOfCars);
    }

    private void generateCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
