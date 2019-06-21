package racinggame;

import com.google.common.base.Preconditions;

public class GameRound {
    private final int maxRound;
    private int currentRound;

    private GameRound(int maxRound, int currentRound) {
        this.maxRound = maxRound;
        this.currentRound = currentRound;
    }

    public GameRound(int maxRound) {
        this(maxRound, 0);
    }

    public GameRound increaseCurrentRound() {
        Preconditions.checkState(!this.isFinished(), "게임이 이미 끝났습니다.");
        return new GameRound(maxRound, currentRound + 1);
    }

    public boolean isFinished() {
        return currentRound >= maxRound;
    }
}
