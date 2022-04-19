package step3.model;

public class Car {

    private final TryStrategy tryStrategy;
    private final Name name;

    private int moveCount;

    public Car(Name name, TryStrategy tryStrategy) {
        this.tryStrategy = tryStrategy;
        this.name = name;
        this.moveCount = 0;
    }

    public void tryOnce() {
        if (tryStrategy.canGoForward()) {
            this.moveCount += 1;
        }
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getMoveCount() {
        return moveCount;
    }
}
