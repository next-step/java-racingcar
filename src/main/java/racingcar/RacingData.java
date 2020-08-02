package racingcar;

public class RacingData {

    private final int numberOfCars;
    private final int tryCount;

    public RacingData(int numberOfCars, int tryCount) {
        this.numberOfCars = numberOfCars;
        this.tryCount = tryCount;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
