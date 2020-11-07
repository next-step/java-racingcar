package racingcar.dto;

public class RaceReadyValue {

    final private int carCount;
    final private int tryCount;

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
