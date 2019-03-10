package racingcar.vo;

public class RacingGameParameter {
    private final int numberOfCar;
    private final int tryCount;

    public RacingGameParameter(int numberOfCar, int tryCount) {
        this.numberOfCar = numberOfCar;
        this.tryCount = tryCount;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getTryCount() {
        return tryCount;
    }
}
