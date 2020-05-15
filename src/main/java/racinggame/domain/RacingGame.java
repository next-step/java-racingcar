package racinggame.domain;

import racinggame.domain.car.RacingCars;
import racinggame.domain.result.RacingGameResult;
import racinggame.domain.result.RacingGameSnapshot;
import racinggame.dto.RacingGameInfo;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCars racingCars;
    private final int numberOfAttempt;

    public RacingGame(RacingGameInfo racingGameInfo) {
        this.racingCars = new RacingCars(racingGameInfo.getParticipantCars());
        this.numberOfAttempt = racingGameInfo.getNumberOfAttempt();
    }

    public RacingGameResult raceWith(Engine engine) {
        List<RacingGameSnapshot> snapshots = new ArrayList<>();

        for (int round = 0; round < numberOfAttempt; round++) {
            snapshots.add(racingCars.race(engine));
        }

        return new RacingGameResult(snapshots);
    }
}
