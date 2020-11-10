package racingcar.domain;

import java.util.List;

public class GameResult {
    private final Winners winners;
    private final RoundRecords roundRecords;

    public GameResult(Winners winners, RoundRecords roundRecords) {
        this.winners = winners;
        this.roundRecords = roundRecords;
    }

    public List<String> getWinnerNames() {
        return winners.getNames();
    }

    public RoundRecords getRoundRecords() {
        return roundRecords;
    }
}
