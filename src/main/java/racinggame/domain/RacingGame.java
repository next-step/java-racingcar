package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCars racingCars;
    private final int numberOfAttempt;

    public RacingGame(int numberOfCar, int numberOfAttempt) {
        this.racingCars = new RacingCars(numberOfCar);
        this.numberOfAttempt = numberOfAttempt;
    }

    public List<RacingGameSnapshot> raceWith(Engine engine) {
        List<RacingGameSnapshot> snapshots = new ArrayList<>();

        for (int round = 0; round < numberOfAttempt; round++) {
            snapshots.add(racingCars.race(engine));
        }

        return snapshots;
    }
}
