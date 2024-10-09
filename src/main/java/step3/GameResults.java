package step3;

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
}
