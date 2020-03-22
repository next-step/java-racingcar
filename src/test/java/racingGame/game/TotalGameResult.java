package racingGame.game;

import java.util.List;

public class TotalGameResult {
    private List<GameResult> gameResults;

    public TotalGameResult(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }
}
