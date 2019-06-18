package racinggame;

import com.google.common.base.Preconditions;

public class GameRound {
    private final int gameRound;
    private int currentRound;

    public GameRound(int gameRound) {
        this.gameRound = gameRound;
        this.currentRound = 0;
    }

    public void increaseCurrentRound() {
        Preconditions.checkState(!this.isFinished(), "게임이 이미 끝났습니다.");
        currentRound += 1;
    }

    public boolean isFinished() {
        return currentRound >= gameRound;
    }
}
