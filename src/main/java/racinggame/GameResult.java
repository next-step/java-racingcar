package racinggame;

import java.util.ArrayList;
import java.util.List;
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
        List<String> winner = new ArrayList<>();
        int maxPosition = 0;
        for (Map.Entry<String, Integer> entry : gameResult.entrySet()) {
            if (maxPosition > entry.getValue()) {
                continue;
            } else if (maxPosition < entry.getValue()) {
                winner.clear();
                maxPosition = entry.getValue();
            }
            winner.add(entry.getKey());
        }

        return String.join(", ", winner);
    }
}
