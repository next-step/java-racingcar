package model;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private ArrayList<Car> cars = new ArrayList<>();

    public void resetWithCarsOf(int numberOfCars) {
        cars = new ArrayList<>();
        createCars(numberOfCars);
    }

    public void progress() {
        for (var car : cars) {
            car.attemptMove();
        }
    }

    public List<Integer> getCarPositions() {
        var carPositions = new ArrayList<Integer>();
        for (var car : cars) {
            carPositions.add(car.getPosition());
        }
        return carPositions;
    }

    private void createCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; ++i) {
            cars.add(new Car());
        }
    }
}
