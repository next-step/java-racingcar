package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingCars racingCars;
    private final int attempt;

    public RacingGame(int racingCar, int attempt) {
        this.racingCars = new RacingCars(racingCar);
        this.attempt = attempt;
    }

    public List<RacingResult> startRace() {
        List<RacingResult> result = new ArrayList<>();

        for (int i = 0; i < attempt; i++) {
            racingCars.racingAttempt();
            List<Integer> resultAttempt = racingCars.getResultAttempt();
            RacingResult racingResult = new RacingResult(attempt, resultAttempt);
            result.add(racingResult);
        }
        return result;
    }

}
