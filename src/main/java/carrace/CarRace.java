package carrace;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private final Cars cars;
    private final int numberOfLaps;
    private final List<List<Integer>> results;

    public CarRace(Cars cars, int numberOfLaps) {
        this.cars = cars;
        this.numberOfLaps = numberOfLaps;
        this.results = new ArrayList<>();
    }

    public void start() {
        for (int i = 0; i < numberOfLaps; i++) {
            cars.move();
            results.add(cars.getPositions());
        }
    }

    public List<List<Integer>> getResults() {
        return new ArrayList<>(results);
    }
}
