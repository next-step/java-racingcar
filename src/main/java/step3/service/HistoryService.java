package step3.service;

import step3.domain.RoundHistory;

import java.util.LinkedHashMap;
import java.util.Map;

public class HistoryService {
    private final Map<Integer, RoundHistory> gameHistory;

    private HistoryService() {
        this.gameHistory = new LinkedHashMap<>();
    }

    public static HistoryService create() {
        return new HistoryService();
    }

    public void record(Integer round, RoundHistory roundHistory) {
        gameHistory.put(round, roundHistory);
    }

    public Map<Integer, RoundHistory> getAll() {
        return gameHistory;
    }

    public RoundHistory getBy(int round) {
        return gameHistory.get(round);
    }
}
