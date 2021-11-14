package step3.service;

import step3.domain.GameHistory;
import step3.domain.RoundHistory;

public class HistoryService {
    private GameHistory gameHistory;

    private HistoryService() {
        gameHistory = GameHistory.create();
    }

    public static HistoryService create() {
        return new HistoryService();
    }

    public void record(Integer round, RoundHistory roundHistory) {
        gameHistory.record(round, roundHistory);
    }

    public GameHistory get() {
        return gameHistory;
    }
}
