package racingcar.domain;

public class Race {
    private int carCount;
    private int tryCount;

    public Race(int carCount, int tryCount) {
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
