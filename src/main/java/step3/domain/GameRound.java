package step3.domain;

import step3.domain.history.GameHistory;
import step3.service.IntNumberGenerator;

public class GameRound {
    private static final int MINIMUM_ROUND = 0;
    private int round;
    private IntNumberGenerator generator;
    private GameHistory history;

    private GameRound() {
    }

    private GameRound(int round, IntNumberGenerator generator) {
        validateIsMinimum(round);
        this.round = round;
        this.generator = generator;
        this.history = GameHistory.create();
    }

    public static GameRound create(int round, IntNumberGenerator generator) {
        return new GameRound(round, generator);
    }

    public GameHistory start(Participant participant) {
        while (round-- != MINIMUM_ROUND) {
            history.record(round, participant.move(generator));
        }
        return history;
    }

    private void validateIsMinimum(int round) {
        if (round <= MINIMUM_ROUND) {
            throw new IllegalArgumentException("시도 회수는 0보다 큰 값을 입력해 주세요");
        }
    }
}
