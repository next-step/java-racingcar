package racingcar.domain;

public class UserInputData {

    private final int carCount;
    private final int tryCount;

    public UserInputData(int carCount, int tryCount) {
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
