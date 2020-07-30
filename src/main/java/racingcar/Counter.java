package racingcar;

final class Counter {
    private final int carCout;
    private final int tryCount;

    public Counter(int carCout, int tryCount) {
        this.carCout = carCout;
        this.tryCount = tryCount;
    }

    public int getCarCout() {
        return carCout;
    }

    public int getTryCount() {
        return tryCount;
    }
}
