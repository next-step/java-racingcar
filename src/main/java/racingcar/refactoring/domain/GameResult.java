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
        return createWinnersName();
    }

    private List<String> createWinnersName() {
        return findFinalRoundResult().findNamesByPosition(getMaxPosition());
    }

    private int getMaxPosition() {
        return findFinalRoundResult().findMaxPosition();
    }

    private RoundResult findFinalRoundResult() {
        return roundResults.get(roundResults.size() - 1);
    }
}
