package racingcar.domain;

import racingcar.policy.MovePolicy;
import racingcar.random.RandomNumberGenerator;

public class RacingGame {
    private final Cars cars;
    private final MovePolicy movePolicy;

    public RacingGame(Cars cars, MovePolicy movePolicy) {
        this.cars = cars;
        this.movePolicy = movePolicy;
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
        cars.moveAll(generator, this.movePolicy);
    }

    private RoundResult getRoundResult() {
        return new RoundResult(cars.toSnapshots());
    }
}
