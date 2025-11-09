package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RandomNumber randomNumber;

    private static final int MIN_ROUND = 1;

    public RacingGame(Cars cars, RandomNumber randomNumber) {
        this.cars = cars;
        this.randomNumber = randomNumber;
    }

    public List<RoundResult> race(int roundCount) {
        validateRoundCount(roundCount);

        List<RoundResult> raceHistory = new ArrayList<>();

        for (int round = 0; round < roundCount; round++) {
            executeRound();
            raceHistory.add(getRoundResult());
        }

        return raceHistory;
    }

    private void validateRoundCount(int roundCount) {
        if (isInvalidRoundCount(roundCount)) {
            throw new IllegalArgumentException("라운드 수는 1이상이어야 합니다.");
        }
    }

    private boolean isInvalidRoundCount(int roundCount) {
        return roundCount < MIN_ROUND;
    }

    private RoundResult getRoundResult() {
        return new RoundResult(cars.getDistances());
    }

    private void executeRound() {
        cars.moveAll(randomNumber);
    }
}
