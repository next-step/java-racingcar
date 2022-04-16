package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(MovingStrategy movingStrategy, int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(movingStrategy));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void runRace() {
        for (Car car : cars) {
            car.move();
        }
    }
}
