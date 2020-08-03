package racingcar;

public class RacingData {

    private final String names;
    private final int numberOfCars;
    private final int tryCount;

    public RacingData(String names, int numberOfCars, int tryCount) {
        this.names = names;
        this.numberOfCars = numberOfCars;
        this.tryCount = tryCount;
    }

    public String getNames() {
        return names;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
