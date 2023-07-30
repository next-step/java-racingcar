package edu.nextstep.camp.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public List<RacingResult> startGame(Cars cars, int movingCount) {
        List<RacingResult> racingResults = new ArrayList<>();

        for (int i = 0; i < movingCount; i++) {
            racingResults.add(cars.moveCars());
        }

        return racingResults;
    }
}
