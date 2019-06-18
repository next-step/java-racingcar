package racinggame;

import java.util.List;

public class GameResult {
    private final List<Integer> gameResult;

    public GameResult(Cars cars) {
        this.gameResult = cars.getPositions();
    }

    public List<Integer> getGameResult() {
        return this.gameResult;
    }
}
