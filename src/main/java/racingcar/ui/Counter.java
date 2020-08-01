package racingcar.ui;

public final class Counter {
    private final int carCount;
    private final int tryCount;

    public Counter(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
