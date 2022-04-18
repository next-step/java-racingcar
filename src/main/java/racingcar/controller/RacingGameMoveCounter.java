package racingcar.controller;

public class RacingGameMoveCounter {
    private static final int DEFAULT = 0;

    private int moveCount;

    public RacingGameMoveCounter() {
        this(DEFAULT);
    }

    protected RacingGameMoveCounter(int moveCount) {
        this.moveCount = moveCount;
    }

    public boolean isSameOrBiggerThen(int number) {
        return this.moveCount >= number;
    }

    public synchronized void increase() {
        this.moveCount++;
    }
}
