package step3.dto;

public class RacingGameCondition {
    private int carCount;
    private int tryCount;

    public RacingGameCondition(int carCount, int tryCount) {
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
