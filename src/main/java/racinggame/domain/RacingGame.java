package racinggame.domain;

import racinggame.dto.RacingGameInfo;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCars racingCars;
    private final int numberOfAttempt;

    public RacingGame(RacingGameInfo racingGameInfo) {
        this.racingCars = new RacingCars(racingGameInfo.getNumberOfCar());
        this.numberOfAttempt = racingGameInfo.getNumberOfAttempt();
    }

    public List<RacingGameSnapshot> raceWith(Engine engine) {
        List<RacingGameSnapshot> snapshots = new ArrayList<>();

        for (int round = 0; round < numberOfAttempt; round++) {
            snapshots.add(racingCars.race(engine));
        }

        return snapshots;
    }
}
