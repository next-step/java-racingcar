package carrace;

import java.util.List;

public class CarRace {

    private final Cars cars;
    private final int numberOfLaps;

    public CarRace(Cars cars, int numberOfLaps) {
        this.cars = cars;
        this.numberOfLaps = numberOfLaps;
    }

    public void start() {
        for (int i = 0; i < numberOfLaps; i++) {
            cars.move();
        }
    }

    public List<Integer> getCarsPosition() {
        return cars.getPositions();
    }
}
