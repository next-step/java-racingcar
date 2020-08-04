package racingcar.ui;

@Deprecated
public final class UserInputInfoWithCount {
    private final int carCount;
    private final int tryCount;

    public UserInputInfoWithCount(int carCount, int tryCount) {
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
