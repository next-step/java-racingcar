package racingcar.domain;

import java.util.List;

public class GameResults {
    private final List<RoundResult> gameResults;

    public GameResults(List<RoundResult> gameResults) {
        this.gameResults = gameResults;
    }

    public int getSize() {
        return gameResults.size();
    }

    public RoundResult getRoundResult(int index) {
        return gameResults.get(index);
    }

    public List<String> findWinners() {
        RoundResult finalResult = getRoundResult(getSize() - 1);
        return finalResult.findWinners();
    }
}
