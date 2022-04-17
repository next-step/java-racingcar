package step3.model;

public class Car {

    private int moveCount;
    private final TryStrategy tryStrategy;

    public Car(TryStrategy tryStrategy) {
        this.moveCount = 0;
        this.tryStrategy = tryStrategy;
    }

    public void tryOnce() {
        if (tryStrategy.canGoForward()) {
            this.moveCount += 1;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
