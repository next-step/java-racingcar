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

    public void randomMove() {
        for (Car car : this.cars) {
            car.randomMove();
        }
    }

    public void printCurrentPositions() {
        for (Car car : this.cars) {
            car.printCurrentPosition();
        }
    }
}
