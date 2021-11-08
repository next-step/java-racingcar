package step3.domain.history;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameHistory {
    private Map<Integer, RoundHistory> gameHistory;

    private GameHistory() {
        this.gameHistory = new LinkedHashMap<>();
    }

    public static GameHistory create() {
        return new GameHistory();
    }

    public void record(Integer round, RoundHistory roundHistory) {
        gameHistory.put(round, roundHistory);
    }

    public Map<Integer, RoundHistory> getAll() {
        return gameHistory;
    }
}
