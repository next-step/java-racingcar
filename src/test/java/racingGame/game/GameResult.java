package racingGame.game;

import java.util.List;

public class GameResult {
    List<Integer> positions;

    public GameResult(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
