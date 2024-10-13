package racingcar.domain;

public class GameRound {
    private static final int START_ROUND = 0;

    private final int lastRound;
    private int currentRound;

    public GameRound(int lastRound) {
        this(0, lastRound);
    }

    public GameRound(int currentRound, int lastRound) {
        this.currentRound = currentRound;
        this.lastRound = lastRound;
    }

    public void increase() {
        currentRound++;
    }
}
