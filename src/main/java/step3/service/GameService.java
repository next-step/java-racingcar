package step3.service;

import step3.domain.GameHistory;
import step3.domain.GameRound;
import step3.domain.Participant;
import step3.domain.RoundHistory;

public class GameService {
    private IntNumberGenerator generator;
    private HistoryService historyService;

    private GameService() {
    }

    private GameService(IntNumberGenerator generator) {
        this.generator = generator;
        this.historyService = HistoryService.create();
    }

    public static GameService create(IntNumberGenerator generator) {
        return new GameService(generator);
    }

    public GameHistory start(GameRound gameRound, Participant participant) {
        while (!gameRound.isEnd()) {
            historyService.record(gameRound.getRound(), startRound(participant));
            gameRound.next();
        }
        return historyService.get();
    }

    private RoundHistory startRound(Participant participant) {
        return RoundHistory.of(participant.move(generator));
    }
}
