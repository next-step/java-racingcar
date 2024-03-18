package racingcar.vo;

import java.util.List;

public class GameResult {

    private final List<RoundResult> roundResults;
    private final List<String> winnerNames;

    public GameResult(final List<RoundResult> roundResults, final List<String> winnerNames) {
        this.roundResults = roundResults;
        this.winnerNames = winnerNames;
    }

    public List<RoundResult> roundResults() {
        return this.roundResults;
    }

    public List<String> winnerNames() {
        return this.winnerNames;
    }
}
