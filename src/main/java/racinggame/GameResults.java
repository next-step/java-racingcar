package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults() {
        this.gameResults = new ArrayList<>();
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }

    public int getSize() {
        return gameResults.size();
    }

    public GameResult getByIndex(int index) {
        return gameResults.get(index);
    }

    public void addResult(GameResult gameResult) {
        gameResults.add(gameResult);
    }
}
