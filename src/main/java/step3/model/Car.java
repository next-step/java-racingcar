package step3.model;

public class Car {

    private final TryStrategy tryStrategy;
    private final String name;

    private int moveCount;

    public Car(Name name, TryStrategy tryStrategy) {
        this.tryStrategy = tryStrategy;
        this.name = name.getValue();
        this.moveCount = 0;
    }

    public void tryOnce() {
        if (tryStrategy.canGoForward()) {
            this.moveCount += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
