package racingcar.domain;

import racingcar.random.RandomNumberGenerator;

public class RacingGame {
    private static final int MIN_ROUND = 1;

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public RaceHistory race(int roundCount, RandomNumberGenerator generator) {
        Round round = new Round(roundCount);
        return executeRounds(round, generator);
    }

    private RaceHistory executeRounds(Round round, RandomNumberGenerator generator) {
        RaceHistory raceHistory = new RaceHistory();

        while (!round.isFinished()) {
            executeRound(generator);
            raceHistory.record(getRoundResult());

            round.next();
        }

        return raceHistory;
    }

    private void executeRound(RandomNumberGenerator generator) {
        cars.moveAll(generator);
    }

    private RoundResult getRoundResult() {
        return new RoundResult(cars.toSnapshots());
    }
}
