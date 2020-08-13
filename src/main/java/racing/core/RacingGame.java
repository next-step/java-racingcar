package racing.core;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public List<Car> cars;
    public int trials;

    public RacingGame(int numberOfCars, int numberOfTrials) {
        this.cars = makeUpEntry(numberOfCars);
        this.trials = numberOfTrials;
    }

    public List<Snapshot> run(Move movement) {
        List<Snapshot> snapshots = new ArrayList<>();
        for (int i = 0; i < trials; i++) {
            cars.stream().forEach(c -> snapshots.add(c.move(movement)));
        }
        return snapshots;
    }

    private List<Car> makeUpEntry(int numberOfCars) {
        List<Car> cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
