package racingcar.domain;

import resource.StringResources;

public class RacingData {

    private final String[] names;
    private final int numberOfCars;
    private final int tryCount;

    public RacingData(String names, int numberOfCars, int tryCount) {
        this.names = names.split(",");
        this.numberOfCars = numberOfCars;

        if (this.names.length != numberOfCars) {
            throw new IllegalArgumentException(StringResources.ERR_INVALID_CAR_DATA);
        }

        this.tryCount = tryCount;
    }

    public String[] getNames() {
        return names;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
