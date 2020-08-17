package racing.core;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public Cars cars;
    public int trials;

    public RacingGame(int numberOfCars, int numberOfTrials) {
        this.cars = makeUpEntry(numberOfCars);
        this.trials = numberOfTrials;
    }

    public List<TrackInfo> run(MoveStrategy movement) {
        List<TrackInfo> allTracks = new ArrayList<>();
        for (int i = 0; i < trials; i++) {
            allTracks.addAll(cars.nextTrial(movement));
        }
        return allTracks;
    }

    private Cars makeUpEntry(int numberOfCars) {
        List<Car> carList = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
        return new Cars(carList);
    }
}
