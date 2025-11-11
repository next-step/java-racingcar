package racingcar.domain;

import racingcar.random.RandomNumber;

public class RacingGame {
    private static final int MIN_ROUND = 1;

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public RaceHistory race(int roundCount, RandomNumber randomNumber) {
        validateRoundCount(roundCount);
        return executeRounds(roundCount, randomNumber);
    }

    private void validateRoundCount(int roundCount) {
        if (isInvalidRoundCount(roundCount)) {
            throw new IllegalArgumentException("라운드 수는 1이상이어야 합니다.");
        }
    }

    private boolean isInvalidRoundCount(int roundCount) {
        return roundCount < MIN_ROUND;
    }

    private RaceHistory executeRounds(int roundCount, RandomNumber randomNumber) {
        RaceHistory raceHistory = new RaceHistory();

        for (int round = 0; round < roundCount; round++) {
            executeRound(randomNumber);
            raceHistory.record(getRoundResult());
        }

        return raceHistory;
    }

    private void executeRound(RandomNumber randomNumber) {
        cars.moveAll(randomNumber);
    }

    private RoundResult getRoundResult() {
        return new RoundResult(cars.toSnapshots());
    }
}
