package racinggame;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private final List<GameResult> gameResultList;

    public GameResults() {
        this.gameResultList = new ArrayList<>();
    }

    public void addRoundResult(GameResult gameResult) {
        gameResultList.add(gameResult);
    }

    public List<GameResult> getGameResultList() {
        return gameResultList;
    }
}
