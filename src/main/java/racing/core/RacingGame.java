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

    public List<TrackInfo> run(MoveStrategy movement) {
        List<TrackInfo> trackInfos = new ArrayList<>();
        for (int i = 0; i < trials; i++) {
            cars.stream().forEach(c -> trackInfos.add(c.move(movement)));
        }
        return trackInfos;
    }

    private List<Car> makeUpEntry(int numberOfCars) {
        List<Car> cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
