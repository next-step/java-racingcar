package step3.model;

public class Car {

    private int successCount;
    private final TryStrategy tryStrategy;

    public Car(TryStrategy tryStrategy) {
        this.successCount = 0;
        this.tryStrategy = tryStrategy;
    }

    public void tryOnce() {
        if (tryStrategy.canGoForward()) {
            this.successCount += 1;
        }
    }

    public int getSuccessCount() {
        return successCount;
    }
}
