package model;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;

    public Race() {
        cars = new ArrayList<>();
    }

    public void resetWithCarsOf(int numberOfCars) {
        cars = new ArrayList<>();
        createCars(numberOfCars);
    }

    public void progress(MoveStrategy moveStrategy) {
        for (var car : cars) {
            car.moveWithStrategy(moveStrategy);
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
