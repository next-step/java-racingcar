package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int attempt;
    private final RacingCars racingCars;

    public RacingGame(int attempt, int racingCar) {
        this.attempt = attempt;
        this.racingCars = new RacingCars(racingCar);
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
