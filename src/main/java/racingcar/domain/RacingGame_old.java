package racingcar.domain;

import java.util.ArrayList;
import java.util.List;


public class RacingGame_old {
    private final RacingCounts racingCounts;
    private final Cars_old carsOld;

    public int getRacingCounts() {
        return racingCounts.getRacingCounts();
    }
    public List<Car_old> getCars() {
        return carsOld.getCars(); }

    public RacingGame_old(int carCounts, RacingCounts racingCounts) {
        this.carsOld = createCars(carCounts);
        this.racingCounts = racingCounts;
    }

    public static Cars_old createCars(int carCounts) {
        List<Car_old> newCars = new ArrayList<>(carCounts);
        for (int i = 0; i < carCounts; i++) {
            newCars.add(new Car_old());
        }
        return Cars_old.createCars(newCars);
    }

    public RaceResults startRacing() {
        RaceResults raceResults = new RaceResults();
        getRaceResults(raceResults).addAll(moveOnceCars());
        return raceResults;
    }

    private List<Car_old> moveOnceCars() {
        Cars_old.moveCars();
        return this.getCars();
    }

    private List<Car_old> getRaceResults(RaceResults raceResults) {
        return raceResults.getRaceResults( );
    }
}


