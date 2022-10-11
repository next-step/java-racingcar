package racingcar.step3_4.domain;

import java.util.List;

public class GameRecord {

    private final List<TryResult> tryResults;
    private final Winners winners;

    public GameRecord(List<TryResult> tryResults, Winners winners) {
        this.tryResults = tryResults;
        this.winners = winners;
    }

    public List<TryResult> getTryResults() {
        return tryResults;
    }

    public Winners getWinners() {
        return winners;
    }
}
