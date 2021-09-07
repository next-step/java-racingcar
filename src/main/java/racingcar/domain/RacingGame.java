package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public List<RacingResults> startRace(int attempt, String[] carNames) {
        RacingCars racingCars = new RacingCars(carNames);

        List<RacingResults> racingResults = new ArrayList<>();
        for (int i = 0; i < attempt; i++) {
            racingCars.racingAttempt();
            RacingResults racingResult = new RacingResults(racingCars);
            racingResults.add(racingResult);
        }
        return racingResults;
    }

}
