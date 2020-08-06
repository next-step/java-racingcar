package racingcar.domain;

import resource.StringResources;

public class RacingData {

    private static final int MAX_SIZE_OF_NAME = 5;

    private final String[] names;
    private final int numberOfCars;
    private final int tryCount;

    public RacingData(String names, int numberOfCars, int tryCount) {
        this.names = names.split(",");
        this.numberOfCars = numberOfCars;
        this.tryCount = tryCount;

        if (this.names.length != numberOfCars) {
            throw new IllegalArgumentException(StringResources.ERR_INVALID_CAR_DATA);
        }

        for (String name : this.names) {
            verifyNameLength(name);
        }
    }

    private void verifyNameLength(String name) {
        if (name.length() > MAX_SIZE_OF_NAME) {
            throw new IllegalArgumentException(StringResources.ERR_LONG_NAME);
        }
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
