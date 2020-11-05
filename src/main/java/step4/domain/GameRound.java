package step4.domain;

import step4.exception.GameEndException;

public class GameRound {

    private int gameRound;
    private int tryCount;

    private GameRound(int tryCount) {
        gameRound = 0;
        this.tryCount = tryCount;
    }

    public static GameRound of(int tryCount) {
        return new GameRound(tryCount);
    }

    public void stackGameRound() {
        if(isGameFinish()){
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
}
