package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(int numberOfCars) {
        this.cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public void moveOnce() {
        for (Car car : cars) {
            car.moveOnce();
        }
    }

    public int[] getCarsPosition() {
        int[] distances = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            distances[i] = cars.get(i).getPosition();
        }

        return distances;
    }
}
