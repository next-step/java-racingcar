package racingcar.domain;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {
    private final RacingCounts racingCounts;
    private final Cars cars;

    public int getRacingCounts() {
        return racingCounts.getRacingCounts();
    }
    public List<Car> getCars() {
        return cars.getCars(); }

    public RacingGame(int carCounts, RacingCounts racingCounts) {
        this.cars = createCars(carCounts);
        this.racingCounts = racingCounts;
    }

    public static Cars createCars(int carCounts) {
        List<Car> newCars = new ArrayList<>(carCounts);
        for (int i = 0; i < carCounts; i++) {
            newCars.add(new Car());
        }
        return Cars.createCars(newCars);
    }

    public RaceResults startRacing() {
        RaceResults raceResults = new RaceResults();
        getRaceResults(raceResults).addAll(moveOnceCars());
        return raceResults;
    }

    private List<Car> moveOnceCars() {
        Cars.moveCars();
        return this.getCars();
    }

    private List<Car> getRaceResults(RaceResults raceResults) {
        return raceResults.getRaceResults( );
    }
}


