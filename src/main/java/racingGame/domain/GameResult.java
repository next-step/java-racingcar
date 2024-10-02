package racingGame.domain;

import java.util.List;

public class GameResult {
    private final List<RoundResult> roundResults;

    public GameResult(List<RoundResult> roundResults) {
        this.roundResults = roundResults;
    }

    public List<RoundResult> getRoundResults() {
        return List.copyOf(roundResults);
    }

    public RoundResult getFinalRound() {
        return roundResults.get(roundResults.size() - 1);
    }

    public List<String> getWinners() {
        return getFinalRound().getWinners();
    }

}
