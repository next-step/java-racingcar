package study.step4.service;

import java.util.Objects;

public class GameCount {
    private static final int GAME_TERMINATED_COUNT = 0;
    private int gameCount;

    public GameCount(int gameCount) {
        if (gameCount <= 0 ) {
            throw new IllegalArgumentException("game 횟수는 1 이상이어야 합니다");
        }
        this.gameCount = gameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCount gameCount1 = (GameCount) o;
        return gameCount == gameCount1.gameCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameCount);
    }

    public boolean isTerminated() {
        return gameCount == GAME_TERMINATED_COUNT;
    }

    public void consume() {
        gameCount--;
    }
}
