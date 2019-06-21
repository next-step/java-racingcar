package racinggame;

import java.util.Map;

public class GameResult {
    private final Map<String, Integer> gameResult;

    public GameResult(Cars cars) {
        this.gameResult = cars.getPositions();
    }

    public Map<String, Integer> getGameResult() {
        return this.gameResult;
    }

    public String getWinner() {
        return String.join(",", Winners.getWinner(gameResult));
    }
}
