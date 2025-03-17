package racingcar.ui;

public class RacingCarInput {

    private final int carCount;
    private final int tryCount;

    public RacingCarInput(int carCount, int tryCount) {
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
