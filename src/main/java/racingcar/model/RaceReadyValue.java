package racingcar.model;

public class RaceReadyValue {

    final int carCount;
    final int tryCount;

    public RaceReadyValue(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
