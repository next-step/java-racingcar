package racingcar.refactoring.domain;

import java.util.List;

public class GameResult {

    private final List<RoundResult> roundResults;

    public GameResult(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public List<String> findWinners() {
        RoundResult finalResult = roundResults.get(roundResults.size() - 1);
        return finalResult.findMaxPositionNames();
    }
}
