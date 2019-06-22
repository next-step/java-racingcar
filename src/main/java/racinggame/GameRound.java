package racinggame;

import com.google.common.base.Preconditions;

public class GameRound {
    public static final int MIN_GAME_ROUND = 1;
    public static final int INITIAL_ROUND = 0;

    private final int maxRound;
    private int currentRound;

    private GameRound(int maxRound, int currentRound) {
        Preconditions.checkArgument(maxRound >= MIN_GAME_ROUND, "GameRound 는 반드시 " + MIN_GAME_ROUND + "이상이어야 합니다.");
        this.maxRound = maxRound;
        this.currentRound = currentRound;
    }

    public GameRound(int maxRound) {
        this(maxRound, INITIAL_ROUND);
    }

    public GameRound increaseCurrentRound() {
        Preconditions.checkState(!this.isFinished(), "게임이 이미 끝났습니다.");
        return new GameRound(maxRound, currentRound + 1);
    }

    public boolean isFinished() {
        return currentRound >= maxRound;
    }
}
