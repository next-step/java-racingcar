package step5.domain;

import step5.exception.GameEndException;
import step5.exception.MinimumTryCountException;

public class GameRound {
    private static final int MIN_TRY_COUNT = 1;
    private int gameRound = 0;
    private final int tryCount;

    private GameRound(int tryCount) {
        validTryCount(tryCount);

        this.tryCount = tryCount;
    }

    public static GameRound of(int tryCount) {
        return new GameRound(tryCount);
    }

    public void stackGameRound() {
        if (isGameFinish()) {
            throw new GameEndException();
        }

        gameRound++;
    }

    public boolean isGameFinish() {
        if (tryCount == gameRound) {
            return true;
        }
        return false;
    }

    private void validTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new MinimumTryCountException(MIN_TRY_COUNT);
        }

    }
}
