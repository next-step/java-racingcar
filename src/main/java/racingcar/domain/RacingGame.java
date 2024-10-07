package racingcar.domain;

import racingcar.dto.AttemptResult;
import racingcar.dto.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final MoveStrategy moveStrategy;
    private final CreationStrategy creationStrategy;

    public RacingGame(final MoveStrategy moveStrategy, final CreationStrategy creationStrategy) {
        this.moveStrategy = moveStrategy;
        this.creationStrategy = creationStrategy;
    }

    public RaceResult play(final String carNames, final int attemptCount) {
        Cars cars = creationStrategy.create(carNames);
        List<AttemptResult> attemptResults = race(cars, attemptCount);
        List<String> winners = cars.getWinners();
        return new RaceResult(attemptResults, winners);
    }

    private List<AttemptResult> race(final Cars cars, final int attemptCount) {
        List<AttemptResult> attemptResults = new ArrayList<>();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            AttemptResult attemptResult = cars.getAttemptResult(moveStrategy);
            attemptResults.add(attemptResult);
        }
        return attemptResults;
    }
}
